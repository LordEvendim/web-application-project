package com.uep.wap.controller;

import com.uep.wap.dto.NewAnswerDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping(path = "/")
    public Iterable<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @PostMapping(path = "/")
    public String addAnswer(@RequestBody NewAnswerDTO answerDTO) {
        answerService.addAnswer(answerDTO);

        return "Answer added";
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<Answer> getUserQuestions(@PathVariable int userId) {
        return answerService.getUserAnswers(userId);
    }
}
