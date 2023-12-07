package com.example.surveys.service.impl;

import com.example.surveys.dto.*;
import com.example.surveys.entity.answer.Answer;
import com.example.surveys.repository.OptionRepository;
import com.example.surveys.repository.QuestionRepository;
import com.example.surveys.repository.SurveyRepository;
import com.example.surveys.repository.UserRepository;
import com.example.surveys.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.aspectj.bridge.Version.getText;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;

    @Override
    public boolean validateResponse(ResponseDTO responseDTO) {
        if (!userRepository.existsById(responseDTO.getId()))
            return false;
        if (!surveyRepository.existsById(responseDTO.getSurveyId()))
            return false;
        return validateAnswers(responseDTO);
    }

    private boolean validateAnswers(ResponseDTO responseDTO) {
        responseDTO.setId(0L);
        for (AnswerDTO answerDTO: responseDTO.getAnswerDTOs()) {
            if (!questionRepository.existsById(answerDTO.getQuestionDTO().getId()))
                return false;
            answerDTO.getQuestionDTO().setText(questionRepository.findById(answerDTO.getQuestionDTO().getId()).get().getQuestionText());

            if (answerDTO.getClass().equals(SingleChoiceAnswerDTO.class)) {
                if (!optionRepository.existsById(
                        ((SingleChoiceAnswerDTO) answerDTO).getOptionDTO().getId()
                ))
                    return false;

                ((SingleChoiceAnswerDTO) answerDTO).getOptionDTO().setAnswer(
                        optionRepository.findById(((SingleChoiceAnswerDTO) answerDTO).getOptionDTO().getId()).get().getAnswer()
                );

            } else if (answerDTO.getClass().equals(MultipleChoiceAnswerDTO.class)) {
                for (OptionDTO optionDTO: ((MultipleChoiceAnswerDTO) answerDTO).getOptionDTOs()) {
                    if (!optionRepository.existsById(
                            optionDTO.getId()
                    ))
                        return false;
                    optionDTO.setAnswer(optionRepository.findById(optionDTO.getId()).get().getAnswer());
                }
            } else if (answerDTO.getClass().equals(TextAnswerDTO.class)) {
                if (((TextAnswerDTO) answerDTO).getText() == null) {
                    ((TextAnswerDTO) answerDTO).setText("");
                }
            }
        }
        return true;
    }
}
