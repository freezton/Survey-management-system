package com.example.surveys.entity.question;

import com.example.surveys.entity.enums.QuestionType;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TextQuestion extends Question {

//    private final QuestionType type = QuestionType.TEXT;
}
