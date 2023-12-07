package com.example.surveys.controller;

import com.example.surveys.entity.Option;
import com.example.surveys.entity.Survey;
import com.example.surveys.entity.question.MultipleChoiceQuestion;
import com.example.surveys.entity.question.SingleChoiceQuestion;
import com.example.surveys.service.SurveyService;
import com.example.surveys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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

    @PostMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestParam Long surveyId, @RequestBody Survey survey) {
        if (!surveyService.isSurveyExists(surveyId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Survey updatedSurvey = surveyService.updateSurvey(surveyId, survey);
        return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<Survey> getSurvey(@RequestParam Long surveyId) {
        if (!surveyService.isSurveyExists(surveyId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Survey survey = surveyService.getSurvey(surveyId);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }
}
