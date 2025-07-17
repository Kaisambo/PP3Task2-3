package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@RestController
public class UserRestContoller {
    private final UserServiceImpl userServiceImpl;

    public UserRestContoller(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<User> listUsers(@RequestParam(required = false) String name) {
        final User user = userServiceImpl.getUserByUsername(name);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
