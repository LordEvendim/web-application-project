package com.uep.wap.service;

import com.uep.wap.dto.NewQuestionDTO;
import com.uep.wap.model.Category;
import com.uep.wap.model.Question;
import com.uep.wap.model.User;
import com.uep.wap.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(NewQuestionDTO questionDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Question question = new Question();
        question.setContent(questionDTO.getContent());
        question.setCreatedAt(currentTime);
        question.setLastEdited(currentTime);
        question.setCreator(new User(questionDTO.getCreatorId()));
        question.setCategory(new Category(questionDTO.getCategoryId()));
        question.setUpvotes(1);

        questionRepository.save(question);

        System.out.println("Question added");
    }

    public void upvoteQuestion(int questionId, long userId) {
        System.out.println("Upvote:" + questionId + " from user: " + userId);
        Optional<Question> targetQuestion = questionRepository.findById(questionId);

        if (targetQuestion.isEmpty()) {
            System.out.println("Question doesn't exist");
            return;
        }

        Question question = targetQuestion.get();
        question.setUpvotes(question.getUpvotes() + 1);

        questionRepository.save(question);
    }

    public List<Question> getUserQuestions(int userId) {
        System.out.println("Getting user questions:" + userId);

        List<Question> questions = questionRepository.findUserQuestions(userId);

        return questions;
    }

    public List<Question> getQuestionsFromCategory(int categoryId) {
        System.out.println("Getting category questions: " + categoryId);

        List<Question> questions = questionRepository.findQuestionsByCategoryId(categoryId);

        return questions;
    }

    public List<Question> getLatestQuestions() {
        System.out.println("Getting latest questions");

        List<Question> questions = questionRepository.findLatestQuestions();

        return questions;
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
