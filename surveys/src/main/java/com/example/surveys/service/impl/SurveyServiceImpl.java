package com.example.surveys.service.impl;

import com.example.surveys.entity.Survey;
import com.example.surveys.entity.question.Question;
import com.example.surveys.repository.QuestionRepository;
import com.example.surveys.repository.SurveyRepository;
import com.example.surveys.repository.UserRepository;
import com.example.surveys.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Survey createSurvey(Survey survey)  {
        survey.setId(0L);
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(Long id, Survey newSurvey) {
        newSurvey.setId(id);
        Optional<Survey> surveyOptional = surveyRepository.findById(id);
        Survey survey = surveyOptional.orElseThrow(
                () -> new ServiceException("No such survey")
        );
        List<Question> list = questionRepository.findBySurveyId(id);
        for (Question question: list) {
            questionRepository.deleteById(question.getId());
        }
        survey.setTitle(newSurvey.getTitle());
        survey.setDescription(newSurvey.getDescription());
        survey.setQuestions(newSurvey.getQuestions());
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getSurvey(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
    }

    @Override
    public Boolean isSurveyExists(Long id) {
        return surveyRepository.findById(id).isPresent();
    }
}
