package com.example.surveys.entity;


import com.example.surveys.entity.answer.Answer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "response")
    private List<Answer> answers;

}
