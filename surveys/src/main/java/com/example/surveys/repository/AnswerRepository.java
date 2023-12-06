package com.example.surveys.repository;

import com.example.surveys.entity.answer.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
