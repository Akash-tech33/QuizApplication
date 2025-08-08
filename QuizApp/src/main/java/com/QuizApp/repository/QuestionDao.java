package com.QuizApp.repository;

import com.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :num", nativeQuery = true)
   List<Question> findRandomQuestionByCategory(String category,int num);
}
