package com.example.surveys.entity;

import com.example.surveys.entity.question.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "options")
@AllArgsConstructor
@NoArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;

    private String answer;

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }
}
