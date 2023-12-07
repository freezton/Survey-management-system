package com.example.surveys.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeName("multiple_choice")
public class MultipleChoiceAnswerDTO extends AnswerDTO {

    private List<OptionDTO> optionDTOs;
}
