package com.example.surveys.entity.question;

import com.example.surveys.entity.Survey;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleChoiceQuestion.class, name = "single_choice"),
        @JsonSubTypes.Type(value = MultipleChoiceQuestion.class, name = "multiple_choice"),
        @JsonSubTypes.Type(value = TextQuestion.class, name = "text")
})
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private Survey survey;

//
//    @OneToMany(mappedBy = "question")
//    private List<Option> options;

}
