package com.uep.wap.repository;

import com.uep.wap.dto.IUserStatisticsDTO;
import com.uep.wap.dto.UserStatisticsDTO;
import com.uep.wap.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u.id as id, u.username as username, COALESCE(SUM(q.upvotes + a.upvotes), 0) as value \n" +
            "FROM users u\n" +
            "LEFT JOIN questions q ON q.creator_id=u.id\n" +
            "LEFT JOIN answers a ON a.creator_id=u.id\n" +
            "GROUP BY u.id\n" +
            "ORDER BY SUM(q.upvotes + a.upvotes) DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<IUserStatisticsDTO> findTopUsersWithMostUpvotes();

    @Query(value = "SELECT u.id as id, u.username as username, COALESCE(COUNT(a.id), 0) as value\n" +
            "FROM users u\n" +
            "LEFT JOIN answers a ON a.creator_id=u.id\n" +
            "GROUP BY u.id\n" +
            "ORDER BY COUNT(a.id) DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<IUserStatisticsDTO> findTopUsersWithMostAnswers();
}
