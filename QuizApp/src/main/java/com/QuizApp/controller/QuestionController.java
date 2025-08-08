package com.QuizApp.controller;

import com.QuizApp.model.Question;
import com.QuizApp.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    QuestionController(QuestionService questionService)
        {
            this.questionService=questionService;
        }
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getQuestions()
    {
        return questionService.getQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category)
    {
        return questionService.getByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
    @PutMapping ("/update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
    {
        return questionService.deleteQuestion(id);
    }

}
