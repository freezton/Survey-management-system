package com.example.surveys.entity.question;

import com.example.surveys.entity.Option;
import com.example.surveys.entity.Survey;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
//@Table(name = "questions")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "question_type")
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    private String questionText;
//
//    @OneToMany(mappedBy = "question")
//    private List<Option> options;

}
