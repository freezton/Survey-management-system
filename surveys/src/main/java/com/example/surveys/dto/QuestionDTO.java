package com.example.surveys.dto;

import com.example.surveys.entity.question.MultipleChoiceQuestion;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import com.example.surveys.entity.question.TextQuestion;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleChoiceQuestionDTO.class, name = "single_choice"),
        @JsonSubTypes.Type(value = MultipleChoiceQuestionDTO.class, name = "multiple_choice"),
        @JsonSubTypes.Type(value = TextQuestionDTO.class, name = "text")
})
public abstract class QuestionDTO {

    private Long id;
    private String questionText;

}
