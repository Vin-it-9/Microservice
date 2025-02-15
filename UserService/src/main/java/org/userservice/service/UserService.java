package org.userservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.userservice.entity.User;
import org.userservice.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUserById(Integer id) {
        User user = userRepository.getUserById(id);
        userRepository.delete(user);
        return user;
    }

    public User updateUser(User user, Integer id) {
        User user1 = userRepository.getUserById(id);
        return userRepository.save(user1);
    }








}
