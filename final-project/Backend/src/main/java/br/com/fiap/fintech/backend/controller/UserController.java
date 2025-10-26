package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.User;
import br.com.fiap.fintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService  userService;

    // Create new User
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    // Get all users
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listAll() {
        return userService.listAll();
    }

    // Get user by id
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User get(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    // Update user
    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
