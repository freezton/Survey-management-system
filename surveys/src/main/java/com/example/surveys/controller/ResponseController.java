package com.example.surveys.controller;

import com.example.surveys.dto.ResponseDTO;
import com.example.surveys.repository.OptionRepository;
import com.example.surveys.repository.QuestionRepository;
import com.example.surveys.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/response")
public class ResponseController {

    private final ResponseService responseService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addResponse(@RequestBody ResponseDTO responseDTO) {
        if (!responseService.validateResponse(responseDTO)) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
