package com.example.surveys.dto;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("text")
public class TextQuestionDTO extends QuestionDTO{

}
