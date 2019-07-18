package edu.mum.cs544.apigateway.controller;

import edu.mum.cs544.apigateway.domain.User;
import edu.mum.cs544.apigateway.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"username","userId"})
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
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model, RedirectAttributes msg){
        System.out.println(user);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "signup";
        }
        String userInputEmail=user.getEmail();
        User dbUser=userService.getUserByEmail(userInputEmail);
        if(dbUser==null) {
            userService.addUser(user);
            return "redirect:/users/all";
        }
        else {
            msg.addFlashAttribute("msg","Email already registered, try another email address");
            return "redirect:/users/signup";
        }
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
    public String checkLogIn(String email, String password, Model model, RedirectAttributes redirectAttributes){
//        System.out.println("printing user input");
//        System.out.println(email+"\n"+password);
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        User result=userService.getUserByObject(user);
//        System.out.println("result from query" +result);
        if(result!=null){
            model.addAttribute("userId",result.getUid() );
            System.out.println("userId after login:"+result.getUid());
            model.addAttribute("username",result.getUserName());
            System.out.println("+++++++++++++++++++");
            System.out.println(model.containsAttribute("userId"));
            return "redirect:/";
        }
        else {
            redirectAttributes.addFlashAttribute("message","Email/Password not matched");
            return "redirect:/users/signin";
        }

    }

    @GetMapping("/logout")
    public String signOut(SessionStatus status,Model model){
        status.setComplete();
        model.addAttribute("username",false);
        model.addAttribute("userId",false);
        System.out.println("===================Inside Logout====================");
        System.out.println( model.containsAttribute("username"));
        System.out.println( model.containsAttribute("userId"));

        System.out.println("===================Inside Logout====================");
        return "redirect:/";
    }
}
