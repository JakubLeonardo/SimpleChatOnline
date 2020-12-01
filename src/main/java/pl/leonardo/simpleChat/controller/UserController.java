package pl.leonardo.simpleChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.leonardo.simpleChat.model.User;
import pl.leonardo.simpleChat.service.UserService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private static AtomicLong idCounter = new AtomicLong();

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    public User getSingleUser(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userService.addUser(new User(idCounter.getAndIncrement(),user.getNick()));
    }
    @PostMapping("/users/{id}")
    public void addSingleUser(@PathVariable Long id, @RequestBody User user){
        userService.addUser(new User(id, user.getNick()));
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
