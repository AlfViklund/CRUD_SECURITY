package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.Initializer;
import web.dao.UserDaoImpl;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private Initializer initializer;

    @GetMapping(value = "/users")
    public String users(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "/user/users";
    }

    @GetMapping(value = "user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user/show";
    }

}
