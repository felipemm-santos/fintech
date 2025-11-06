package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.Goal;
import br.com.fiap.fintech.backend.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goal")
public class GoalController {
    @Autowired
    private GoalService goalService;

    // Create new goal
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Goal create(@RequestBody Goal goal) {
        return goalService.save(goal);
    }

    // Get all goals
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Goal> listAll() {
        return  goalService.listAll();
    }

    // Get goal by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Goal findById(@PathVariable Long id) {
        return goalService.findById(id);
    }

    // Update goal
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Goal update(@PathVariable Long id, @RequestBody Goal goal) {
        return goalService.update(id, goal);
    }

    // Delete goal
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        goalService.delete(id);
    }

}
