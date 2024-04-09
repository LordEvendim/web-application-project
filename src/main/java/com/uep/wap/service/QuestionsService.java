package com.uep.wap.service;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Question;
import com.uep.wap.model.User;
import com.uep.wap.repository.QuestionRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class QuestionsService {
    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(QuestionDTO questionDTO) {
        long currentTime = Instant.now().getEpochSecond();;

        Question question = new Question(questionDTO.getContent(), questionDTO.getCreator(), currentTime, currentTime, questionDTO.getCategory(), questionDTO.getTags());
        questionRepository.save(question);
        System.out.println("Question added!");
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
