package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printUsers(ModelMap model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "/users";
    }

    @GetMapping("/create")
    public String createUserForm(User user) {
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }



    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.changeUser(user);
        return "redirect:/";
    }


}
