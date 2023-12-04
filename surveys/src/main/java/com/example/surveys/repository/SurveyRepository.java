package com.example.surveys.repository;

import com.example.surveys.entity.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {


}
