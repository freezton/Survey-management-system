package com.example.surveys.entity.answer;

import com.example.surveys.entity.Option;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SingleChoiceAnswer extends Answer {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "option_id")
    private Option option;
}
