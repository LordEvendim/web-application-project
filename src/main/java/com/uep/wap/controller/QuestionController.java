package com.uep.wap.controller;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Question;
import com.uep.wap.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/")
    public Iterable<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(path = "/")
    public String addQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.addQuestion(questionDTO);

        return "Question added";
    }
}
