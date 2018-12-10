package com.projects.usermanagement.service;

import com.projects.usermanagement.exception.MissingDataException;
import com.projects.usermanagement.exception.ObjectAlreadyExistsException;
import com.projects.usermanagement.model.User;
import com.projects.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByLoginId(String userId) {
        return userRepository.findByLoginId(userId);
    }

    public List<User> getAllUsers(List<User> users) {
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    public User createUser(User user) throws ObjectAlreadyExistsException, MissingDataException{

        if (user.getLoginId() == null || user.getLoginId().isEmpty()) {
            throw new MissingDataException("loginId is a mandatory input field.");
        }
        if (getUserByLoginId(user.getLoginId()) != null) {
            throw new ObjectAlreadyExistsException("User with loginId: " + user.getLoginId() + " already exists.");
        }

        userRepository.save(user);
        return user;
    }

    public User deleteUserByLoginId(String loginId) {
        User user = getUserByLoginId(loginId);
        if (user != null) {
            userRepository.delete(user);
        }

        return user;
    }
}
