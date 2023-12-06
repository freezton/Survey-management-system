package com.example.surveys.repository;

import com.example.surveys.entity.question.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
