package com.uep.wap.controller;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.service.AnswerService;
import com.uep.wap.service.QuestionService;
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
    public String addAnswer(@RequestBody AnswerDTO answerDTO) {
        answerService.addAnswer(answerDTO);

        return "Answer added";
    }
}
