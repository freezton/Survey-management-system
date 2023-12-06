package com.example.surveys.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeName("single_choice")
public class SingleChoiceQuestionDTO extends QuestionDTO {

    private List<OptionDTO> options;

}
