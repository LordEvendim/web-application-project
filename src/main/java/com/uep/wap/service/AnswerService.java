package com.uep.wap.service;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Category;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public void addAnswer(AnswerDTO answerDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Answer answer = new Answer(answerDTO.getContent(), answerDTO.getCreator(), currentTime, currentTime, answerDTO.getParentQuestion());
        answerRepository.save(answer);

        System.out.println("Answer added");
    }

    public Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
