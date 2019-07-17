package edu.mum.cs544.apigateway.controller;

import edu.mum.cs544.apigateway.domain.User;
import edu.mum.cs544.apigateway.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/")
    public String userHome(){
        return "home";
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
        return "signup";
    }

    @PostMapping("/create")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model){
        System.out.println(user);
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
    public String saveUpdate(@ModelAttribute User user, BindingResult result, Model model){
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

    @GetMapping("/signin")
    public String newLogIn(){
        return "signin";
    }

    @PostMapping("/login")
    public String checkLogIn(String email, String password, HttpSession session, RedirectAttributes redirectAttributes){
        System.out.println("printing user input");
        System.out.println(email+"\n"+password);
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        Long result=userService.getUserIdByObject(user);
        System.out.println("result from query" +result);
        if(result!=null){
            session.setAttribute("userId", result);
            return "home";
        }
        else {
            redirectAttributes.addFlashAttribute("message","Email/Password not matched");
            return "redirect:/users/signin";
        }

    }
}
