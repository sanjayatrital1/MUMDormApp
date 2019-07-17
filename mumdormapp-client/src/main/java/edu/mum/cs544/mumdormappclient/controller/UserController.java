package edu.mum.cs544.mumdormappclient.controller;

import edu.mum.cs544.mumdormappclient.domain.Address;
import edu.mum.cs544.mumdormappclient.domain.User;
import edu.mum.cs544.mumdormappclient.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/")
    public String userHome(){
        return "index";
    }



    @GetMapping(value = "/all")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAll());
        return "usersList";
    }

    @GetMapping("/search/{id}")
    public String getUser(@PathVariable long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "userDetail";
    }

    @GetMapping("/signup")
    public String signupform(Model model){
        model.addAttribute("user", new User());
       // model.addAttribute("address", new Address());
        return "signup";
    }

    @PostMapping("/create")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "signup";
        }

        userService.addUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/modify/{id}")
    public String updateUser(@PathVariable long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "changeDetail";
    }
    @PostMapping("/modify")
    public String saveUpdate(@ModelAttribute User user, BindingResult result, @PathVariable long id, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "redirct:/modify";
        }
        userService.update(user);
        return "redirect:/users/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "redirect:/users/all";
    }

}
