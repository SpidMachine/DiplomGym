package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.services.userServ.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserGym> getUserById(@PathVariable Long id) {
        UserGym userGym = userService.findUserById(id);
        return new ResponseEntity<>(userGym, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<UserGym> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<UserGym> createUser(@RequestBody UserGym userGym) {
        UserGym _userGym = userService.createUser(userGym);
        return new ResponseEntity<>(_userGym, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserGym> updateUser(@PathVariable Long id, @RequestBody UserGym userGym) {
        UserGym _userGym = userService.updateUser(id, userGym);
        return new ResponseEntity<>(_userGym, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserGym> deleteUser(@PathVariable Long id) {
        UserGym deleteUserGym = userService.deleteUser(id);
        return new ResponseEntity<>(deleteUserGym, HttpStatus.OK);
    }
}
