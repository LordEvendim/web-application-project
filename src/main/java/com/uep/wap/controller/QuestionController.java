package com.uep.wap.controller;

import com.uep.wap.dto.NewQuestionDTO;
import com.uep.wap.model.Question;
import com.uep.wap.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public String addQuestion(@RequestBody NewQuestionDTO questionDTO) {
        questionService.addQuestion(questionDTO);

        return "Question added";
    }

    @GetMapping(path = "/{questionId}")
    public Optional<Question> getQuestionById(@PathVariable int questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<Question> getUserQuestions(@PathVariable int userId) {
        return questionService.getUserQuestions(userId);
    }

    @GetMapping(path = "/category/{categoryId}")
    public Iterable<Question> getCategoryQuestions(@PathVariable int categoryId) {
        return questionService.getQuestionsFromCategory(categoryId);
    }

    @GetMapping(path = "/latest")
    public Iterable<Question> getLatestQuestions() {
        return questionService.getLatestQuestions();
    }
}
