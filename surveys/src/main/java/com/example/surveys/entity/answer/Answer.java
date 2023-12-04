package com.example.surveys.entity.answer;

import com.example.surveys.entity.question.Question;
import com.example.surveys.entity.Response;
import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Table(name = "answers")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "response_id")
    private Response response;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "option_id")
//    private Option option;

}
