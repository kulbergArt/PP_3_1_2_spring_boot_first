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

    // @DeleteMapping не работает у моей реализации. Ошибка: There was an unexpected error (type=Method Not Allowed, status=405)..
    // При @PostMapping та же ошибка. Что логично. Работает только через @GetMapping.
    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    // @PatchMapping не работает у моей реализации. Ошибка: Request method 'POST' not supported.
    // При @GetMapping та же ошибка. Что логично. Работает только через @PostMapping.
    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("editUser") User editUser) {
        userService.updateUser(editUser);
        return "redirect:/";
    }

}
