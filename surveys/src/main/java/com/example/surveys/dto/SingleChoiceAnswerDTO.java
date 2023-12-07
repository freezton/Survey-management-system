package com.example.surveys.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("single_choice")
public class SingleChoiceAnswerDTO extends AnswerDTO {

    private OptionDTO optionDTO;
}
