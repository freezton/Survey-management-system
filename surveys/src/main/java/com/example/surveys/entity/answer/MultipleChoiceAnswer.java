package com.example.surveys.entity.answer;

import com.example.surveys.entity.Option;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MultipleChoiceAnswer extends Answer {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "option_id")
    private List<Option> options;
}
