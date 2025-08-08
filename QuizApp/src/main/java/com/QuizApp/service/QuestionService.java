package com.QuizApp.service;

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
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch(Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Question question) {

        questionDao.save(question);
        return  new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        Optional<Question> existing = questionDao.findById(question.getId());
        if (existing.isPresent()) {
            questionDao.save(question);
            return new ResponseEntity<>("updated",HttpStatus.OK);
        } else
            return new ResponseEntity<>("ID NOT Found",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        if (questionDao.existsById(id)) {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted Suceesfully ",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
}



