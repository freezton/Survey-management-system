package com.example.surveys.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleChoiceAnswerDTO.class, name = "single_choice"),
        @JsonSubTypes.Type(value = MultipleChoiceAnswerDTO.class, name = "multiple_choice"),
        @JsonSubTypes.Type(value = TextAnswerDTO.class, name = "text")
})
public abstract class AnswerDTO {

    private Long id;

    private Long responseId;

    private QuestionDTO questionDTO;

}
