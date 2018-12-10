package com.projects.usermanagement.controller;

import com.projects.usermanagement.exception.MissingDataException;
import com.projects.usermanagement.exception.ObjectAlreadyExistsException;
import com.projects.usermanagement.model.User;
import com.projects.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/v1/users/loginid/{loginId}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable String loginId) {
        HttpStatus status;
        User user = null;
        try {
            user = userService.getUserByLoginId(loginId);
            if (user == null) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(user, status);
    }

    @RequestMapping(
            value = "/v1/users",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<List<User>> getUsers() {
        HttpStatus status;
        List<User> users = new ArrayList<>();

        try {
            userService.getAllUsers(users);
            status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(users, status);
    }

    @RequestMapping(
            value = "/v1/users",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        HttpStatus status;
        try {
            userService.createUser(user);
            if (user == null) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.OK;
            }
        } catch (ObjectAlreadyExistsException oee) {
            status = HttpStatus.CONFLICT;
        } catch (MissingDataException mde) {
            status = HttpStatus.PARTIAL_CONTENT;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(user, status);
    }

    @RequestMapping(
            value = "/v1/users/loginid/{loginId}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity<User> deleteUser(@PathVariable String loginId) {
        HttpStatus status;
        User user = null;
        try {
            user = userService.deleteUserByLoginId(loginId);
            if (user == null) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(user, status);
    }
}
