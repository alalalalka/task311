package com.example.task311.controller;


import com.example.task311.model.User;
import com.example.task311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showTableOfUsers(Model model) {
        model.addAttribute("users", userService.showTableOfUsers());
        return "index";
    }

    @GetMapping("/new")
    public String AddNewUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.addNewUser(user);
        return "redirect:/";

    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable("id")int id){
        userService.edit(id, user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.delete(id);
        return "redirect:/";

    }

}
