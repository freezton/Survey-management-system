package com.example.surveys.service.impl;

import com.example.surveys.dto.QuestionDTO;
import com.example.surveys.dto.SurveyDTO;
import com.example.surveys.entity.Survey;
import com.example.surveys.entity.question.Question;
import com.example.surveys.repository.QuestionRepository;
import com.example.surveys.repository.SurveyRepository;
import com.example.surveys.repository.UserRepository;
import com.example.surveys.service.QuestionFactory;
import com.example.surveys.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final QuestionFactory questionFactory;

    @Override
    public Survey createSurvey(Survey survey)  {
//        Survey survey = new Survey();
//        survey.setId(0L);
//        survey.setTitle(surveyDTO.getTitle());
//        survey.setDescription(surveyDTO.getDescription());
//        survey.setCreator(userRepository.findById(surveyDTO.getCreatorId()).get());
//        for (QuestionDTO questionDTO: surveyDTO.getQuestions()) {
//            Question question = questionFactory.createNewQuestion(questionDTO);
//            question.setSurvey(survey);
//            survey.getQuestions().add(question);
//        }
        return surveyRepository.saveAndFlush(survey);
    }

    @Override
    public Survey updateSurvey(Long id, Survey survey) {
//        Survey existingSurvey = surveyRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
//        existingSurvey.setTitle(survey.getTitle());
//        existingSurvey.setDescription(survey.getDescription());
//        existingSurvey.setQuestions(survey.getQuestions());
//        return surveyRepository.save(existingSurvey);
        return null;
    }

    @Override
    public Survey getSurvey(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
    }
}
