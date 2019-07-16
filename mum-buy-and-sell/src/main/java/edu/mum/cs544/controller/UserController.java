package edu.mum.cs544.controller;

import edu.mum.cs544.domain.User;
import edu.mum.cs544.service.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping(value ="/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/search/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }


    @PostMapping("/create")
    public RedirectView addUser(@RequestBody User user){
        userService.addUser(user);
        return new RedirectView("/users/all");
    }

    @GetMapping("/modify/{id}")
    public User updateUser(@PathVariable long id, Model model){
        return userService.getUser(id);
    }

    @PostMapping("/modify")
    public RedirectView updateUser(@RequestBody User user){
        userService.update(user);
        return new RedirectView("/users/all");
    }

    @PutMapping("/modify")
    public void saveUpdate(@RequestBody User user){
        userService.update(user);

    }

    @DeleteMapping("/remove/{id}")
    public void deleteUser(@PathVariable long id){
        userService.delete(id);
    }

}
