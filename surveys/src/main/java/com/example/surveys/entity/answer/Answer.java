package com.example.surveys.entity.answer;

import com.example.surveys.entity.question.MultipleChoiceQuestion;
import com.example.surveys.entity.question.Question;
import com.example.surveys.entity.Response;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import com.example.surveys.entity.question.TextQuestion;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "answer_type")
public abstract class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "response_id")
    @JsonBackReference
    private Response response;

    private Long questionId;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;

}
