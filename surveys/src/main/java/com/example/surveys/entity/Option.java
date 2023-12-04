package com.example.surveys.entity;

import com.example.surveys.entity.question.Question;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    private String answer;

}
