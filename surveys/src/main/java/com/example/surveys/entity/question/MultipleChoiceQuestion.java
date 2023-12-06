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
@JsonTypeName("multiple_choice")
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceQuestion extends Question {

//    private final QuestionType type = QuestionType.MULTIPLE_CHOICE;

    @OneToMany(mappedBy = "question")
    @EqualsAndHashCode.Exclude
    private List<Option> options;
}
