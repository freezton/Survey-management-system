package com.example.surveys.entity;

import com.example.surveys.entity.question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "survey")
    private List<Question> questions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private User creatorId;
}
