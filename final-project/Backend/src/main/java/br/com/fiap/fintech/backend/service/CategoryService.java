package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.Category;
import br.com.fiap.fintech.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // save
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // findById
    public Category findById(Long id) throws RuntimeException {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        return category.get();
    }

    // listAll
    public List<Category> listAll(){
        return categoryRepository.findAll();
    }

    // update
    public Category update(Long id, Category category) throws RuntimeException {
        Optional<Category> oldCategory = categoryRepository.findById(id);
        if(!oldCategory.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        return categoryRepository.save(category);
    }

    // delete
    public void delete(Long id) throws RuntimeException {
        Optional<Category> category  = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.delete(category.get());
    }
}