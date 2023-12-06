package com.example.surveys.dto;

import lombok.Data;

import java.util.List;

@Data
public class SurveyDTO {

    private Long id;
    private String title;
    private String description;
    private List<QuestionDTO> questions;
    private Long creatorId;

}
