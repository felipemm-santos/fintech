package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.Category;
import br.com.fiap.fintech.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Create new category
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    // Get all categories
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Category> listAll() {
        return  categoryService.listAll();
    }

    // Get category by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    // Update category
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    // Delete category
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
