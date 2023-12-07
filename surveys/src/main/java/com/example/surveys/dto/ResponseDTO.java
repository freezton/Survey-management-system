package com.example.surveys.dto;

import com.example.surveys.entity.Survey;
import com.example.surveys.entity.User;
import com.example.surveys.entity.answer.Answer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {

    private Long id;

    private Long userId;

    private Long surveyId;

    private List<AnswerDTO> answerDTOs;
}
