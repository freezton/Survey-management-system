package com.example.surveys.configuration;

import com.example.surveys.dto.*;
import com.example.surveys.entity.Option;
import com.example.surveys.entity.question.MultipleChoiceQuestion;
import com.example.surveys.entity.question.Question;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import com.example.surveys.entity.question.TextQuestion;
import com.example.surveys.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class SurveyConfiguration {

    private final OptionRepository optionRepository;

    public SingleChoiceQuestion processSingleChoiceQuestionDTO(QuestionDTO dto) {
        SingleChoiceQuestion question = new SingleChoiceQuestion();
        question.setQuestionText(dto.getQuestionText());
        for (OptionDTO optionDTO: ((SingleChoiceQuestionDTO)dto).getOptions()) {
            Option option = new Option(0L, question, optionDTO.getAnswer());
            question.getOptions().add(option);
        }
        return question;
    }

    public MultipleChoiceQuestion processMultipleChoiceQuestionDTO(QuestionDTO dto) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion();
        question.setQuestionText(dto.getQuestionText());
        for (OptionDTO optionDTO: ((MultipleChoiceQuestionDTO)dto).getOptions()) {
            Option option = new Option(0L, question, optionDTO.getAnswer());
            question.getOptions().add(option);
        }
        return question;
    }

    public TextQuestion processTextQuestionDTO(QuestionDTO dto) {
        TextQuestion question = new TextQuestion();
        question.setQuestionText(dto.getQuestionText());
        return question;
    }

    @SneakyThrows
    @Bean
    public HashMap<Class<? extends QuestionDTO>, Method> getQuestionClasses() {
        HashMap<Class<? extends QuestionDTO>, Method> questionClasses = new HashMap<>();
        questionClasses.put(SingleChoiceQuestionDTO.class, getClass().getMethod("processSingleChoiceQuestionDTO", QuestionDTO.class));
        questionClasses.put(MultipleChoiceQuestionDTO.class, getClass().getMethod("processMultipleChoiceQuestionDTO", QuestionDTO.class));
        questionClasses.put(TextQuestionDTO.class, getClass().getMethod("processTextQuestionDTO", QuestionDTO.class));
        return questionClasses;
    }


}
