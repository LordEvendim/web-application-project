package com.uep.wap.service;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Category;
import com.uep.wap.model.Question;
import com.uep.wap.model.Tag;
import com.uep.wap.repository.CategoryRepository;
import com.uep.wap.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        categoryRepository.save(category);

        System.out.println("Category added");
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
