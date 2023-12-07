package com.example.surveys.repository;

import com.example.surveys.entity.question.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findBySurveyId(Long id);

}
