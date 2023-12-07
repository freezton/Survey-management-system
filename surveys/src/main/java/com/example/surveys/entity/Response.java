package com.example.surveys.entity;


import com.example.surveys.entity.answer.Answer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "survey_id")
//    private Survey survey;

    private Long userId;

    private Long surveyId;

    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> answers;
}
