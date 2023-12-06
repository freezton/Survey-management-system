package com.example.surveys.entity.question;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@DiscriminatorValue("text")
@JsonTypeName("text")
public class TextQuestion extends Question {

}
