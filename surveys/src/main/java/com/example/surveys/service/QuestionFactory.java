package com.example.surveys.service;

import com.example.surveys.configuration.SurveyConfiguration;
import com.example.surveys.dto.MultipleChoiceQuestionDTO;
import com.example.surveys.dto.OptionDTO;
import com.example.surveys.dto.QuestionDTO;
import com.example.surveys.dto.SingleChoiceQuestionDTO;
import com.example.surveys.entity.Option;
import com.example.surveys.entity.question.Question;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionFactory {

    private final HashMap<Class<? extends QuestionDTO>, Method> questionClassesHashMap;
    private final SurveyConfiguration surveyConfiguration;

    @SneakyThrows
    public Question createNewQuestion(QuestionDTO dto) {
        return (Question) questionClassesHashMap.get(dto.getClass()).invoke(surveyConfiguration, dto);
    }

}
