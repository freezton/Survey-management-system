package com.example.surveys.service;

import com.example.surveys.entity.Survey;

import java.util.Optional;

public interface SurveyService {

    Survey createSurvey(Survey survey);

    Survey updateSurvey(Long id, Survey survey);

    Survey getSurvey(Long id);

    Boolean isSurveyExists(Long id);
}
