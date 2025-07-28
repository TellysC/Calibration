package com.example.calibration_api.domain.service;

import com.example.calibration_api.domain.model.User;
import com.example.calibration_api.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public User register(final User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(final User user, final Long userId) {

        User existingUser = search(userId);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setUserRole(user.getUserRole());
        return userRepository.save(existingUser);
    }

    @Transactional
    public User search(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
    }

    @Transactional
    public void delete(final Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        userRepository.delete(user);
    }

    @Transactional
    public List<User> list() {
        return userRepository.findAll();
    }
}
