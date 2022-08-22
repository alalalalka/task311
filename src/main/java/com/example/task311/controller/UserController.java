package com.example.task311.controller;

import com.example.task311.model.User;
import com.example.task311.repository.UserRepository;
import com.example.task311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/")
    public String showTableOfUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


    @GetMapping("/new")
    public String showFormAddNewUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "redirect:/";

    }


    @GetMapping ("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        User user = userRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user",user);
        return "edit";

    }

    @PostMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, User user,
                       BindingResult result, Model model){
        if (result.hasErrors()) {
            user.setId(id);
            return "edit";
        }
        userRepository.save(user);
        return "redirect:/";


    }



    @GetMapping ("/delete/{id}")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/";

    }
}
