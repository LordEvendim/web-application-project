package com.uep.wap.service;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.dto.NewAnswerDTO;
import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Category;
import com.uep.wap.model.Question;
import com.uep.wap.model.User;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public void addAnswer(NewAnswerDTO answerDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Answer answer = new Answer();
        answer.setContent(answerDTO.getContent());
        answer.setCreator(new User(answerDTO.getCreatorId()));
        answer.setUpvotes(0);
        answer.setCreatedAt(currentTime);
        answer.setLastEdited(currentTime);
        answer.setParentQuestion(new Question(answerDTO.getParentQuestionId()));
        answerRepository.save(answer);

        System.out.println("Answer added");
    }

    public void upvoteAnswer(int answerId, long userId) {
        System.out.println("Upvote:" + answerId + " from user: " + userId);
        Optional<Answer> targetAnswer = answerRepository.findById(answerId);

        if (targetAnswer.isEmpty()) {
            System.out.println("Answer doesn't exist");
            return;
        }

        Answer answer = targetAnswer.get();
        answer.setUpvotes(answer.getUpvotes() + 1);

        answerRepository.save(answer);
    }

    public List<Answer> getUserAnswers(int userId) {
        System.out.println("Getting user answeres:" + userId);

        List<Answer> answers = answerRepository.findUserAnswers(userId);

        return answers;
    }

    public Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
