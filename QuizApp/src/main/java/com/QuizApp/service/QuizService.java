package com.QuizApp.service;

import com.QuizApp.model.QuestionWrapper;
import com.QuizApp.model.Quiz;
import com.QuizApp.model.Response;
import com.QuizApp.repository.QuizDao;
import com.QuizApp.model.Question;
import com.QuizApp.repository.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
   @Autowired
   QuestionDao questionDao;

   public  ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUsers=new ArrayList<>();
        for(Question q:questionFromDB)
        {
           QuestionWrapper qw=  new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),
                   q.getOption3(),q.getOption4());
                    questionForUsers.add(qw);
        }
        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }

    public  ResponseEntity<Integer> calculateResult(int id,List<Response> responses) {
       Quiz quiz=quizDao.findById(id).get();
       List<Question> questions=quiz.getQuestions();
       int right=0;
       int i=0;
       for(Response response: responses)
       {
           if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
               right++;
           }
          i++;
       }
       return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
