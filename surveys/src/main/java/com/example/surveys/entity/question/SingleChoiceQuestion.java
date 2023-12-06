package com.example.surveys.entity.question;

import com.example.surveys.entity.Option;
import com.example.surveys.entity.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@JsonTypeName("single_choice")
@AllArgsConstructor
@NoArgsConstructor
public class SingleChoiceQuestion extends Question {

//    private final QuestionType type = QuestionType.SINGLE_CHOICE;

    @OneToMany(mappedBy = "question")
    @EqualsAndHashCode.Exclude
    private List<Option> options;
}
