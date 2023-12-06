package com.example.surveys.repository;

import com.example.surveys.entity.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findById(Long id);

}
