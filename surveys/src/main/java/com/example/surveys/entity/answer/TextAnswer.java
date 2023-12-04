package com.example.surveys.entity.answer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TextAnswer extends Answer {

    @Column(name = "text")
    private String text;
}
