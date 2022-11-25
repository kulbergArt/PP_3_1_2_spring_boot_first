package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String MainPage(@ModelAttribute("newUser") User user,
                           @ModelAttribute("editUser") User editUser,
                           Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PatchMapping(value = "/update")
    public String updateUser(@ModelAttribute("editUser") User editUser) {
        userService.updateUser(editUser);
        return "redirect:/";
    }

}
