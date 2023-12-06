package com.example.surveys.service.impl;

import com.example.surveys.entity.Survey;
import com.example.surveys.repository.SurveyRepository;
import com.example.surveys.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(Long id, Survey survey) {
        Survey existingSurvey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
        existingSurvey.setTitle(survey.getTitle());
        existingSurvey.setDescription(survey.getDescription());
//        existingSurvey.setQuestions(survey.getQuestions());
        return surveyRepository.save(existingSurvey);
    }

    @Override
    public Survey getSurvey(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
    }
}
