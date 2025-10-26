package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.User;
import br.com.fiap.fintech.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) throws RuntimeException {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new RuntimeException("User not found");
        }

        return user.get();
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User update(Integer id, User user) throws RuntimeException {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        return userRepository.save(user);
    }

    public void deleteUser(Integer id) throws RuntimeException {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        
        userRepository.delete(userOptional.get());
    }
}
