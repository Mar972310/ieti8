package edu.eci.ieti.ieti8.controller;

import edu.eci.ieti.ieti8.dto.UserDto;
import edu.eci.ieti.ieti8.entity.User;
import edu.eci.ieti.ieti8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private int id;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.id = 1;
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = new User(String.valueOf(this.id), userDto.getMail(), userDto.getName());
        id++;
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.read(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        User user = new User(id, userDto.getMail(), userDto.getName());
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }
}
