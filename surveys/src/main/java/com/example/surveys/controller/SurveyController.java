package com.example.surveys.controller;

import com.example.surveys.dto.SurveyDTO;
import com.example.surveys.entity.Option;
import com.example.surveys.entity.Survey;
import com.example.surveys.entity.User;
import com.example.surveys.entity.question.MultipleChoiceQuestion;
import com.example.surveys.entity.question.Question;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import com.example.surveys.exception.ServiceException;
import com.example.surveys.repository.UserRepository;
import com.example.surveys.service.QuestionFactory;
import com.example.surveys.service.SurveyService;
import com.example.surveys.service.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/survey")
public class SurveyController {

    private final SurveyService surveyService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        if (!userService.isUserExists(survey.getCreator().getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Survey createdSurvey = surveyService.createSurvey(survey);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestParam Long surveyId, @RequestBody Survey survey) {
//        Survey updatedSurvey = surveyService.updateSurvey(surveyId, survey);
        return new ResponseEntity<>(/*updatedSurvey, */HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<Survey> getSurvey(@RequestParam Long surveyId) {
        Survey survey = surveyService.getSurvey(surveyId);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Survey> test() {
        SingleChoiceQuestion question1 = new SingleChoiceQuestion();
        question1.setOptions(
                Arrays.asList(
                        new Option(1L, question1, "Answer1"),
                        new Option(1L, question1, "Answer2")
                )
        );
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion();
        question2.setOptions(
                Arrays.asList(
                        new Option(1L, question2, "Answer34"),
                        new Option(1L, question2, "Answer45")
                )
        );
        System.out.println(question1);
        System.out.println(question2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
