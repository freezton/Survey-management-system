package com.example.surveys.entity.question;

import com.example.surveys.entity.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor
@JsonTypeName("text")
public class TextQuestion extends Question {

//    private final QuestionType type = QuestionType.TEXT;
}
