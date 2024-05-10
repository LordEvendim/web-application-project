package com.uep.wap.repository;

import com.uep.wap.model.Answer;
import com.uep.wap.model.Category;
import com.uep.wap.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    @Query(value = "SELECT a.* FROM answers a WHERE a.creator_id=?1", nativeQuery = true)
    List<Answer> findUserAnswers(int userId);
}
