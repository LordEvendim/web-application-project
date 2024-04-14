package com.uep.wap.repository;

import com.uep.wap.model.Category;
import com.uep.wap.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
