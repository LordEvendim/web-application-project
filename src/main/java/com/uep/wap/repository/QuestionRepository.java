package com.uep.wap.repository;

import com.uep.wap.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query(value = "SELECT q.* FROM questions q ORDER BY q.created_at DESC LIMIT 10", nativeQuery = true)
    List<Question> findLatestQuestions();

    @Query(value = "SELECT q.* FROM questions q WHERE q.creator_id=?1", nativeQuery = true)
    List<Question> findUserQuestions(int userId);

    @Query(value = "SELECT q.* FROM questions q WHERE q.category_id=?1", nativeQuery = true)
    List<Question> findQuestionsByCategoryId(int category_id);
}
