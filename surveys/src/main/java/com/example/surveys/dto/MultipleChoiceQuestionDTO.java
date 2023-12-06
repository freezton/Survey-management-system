package com.example.surveys.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeName("multiple_choice")
public class MultipleChoiceQuestionDTO extends QuestionDTO {

    private List<OptionDTO> options;
}
