package com.example.surveys.entity.question;

import com.example.surveys.entity.Option;
import com.example.surveys.entity.enums.QuestionType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class SingleChoiceQuestion extends Question {

//    private final QuestionType type = QuestionType.SINGLE_CHOICE;

    @OneToMany(mappedBy = "question")
    private List<Option> options;
}
