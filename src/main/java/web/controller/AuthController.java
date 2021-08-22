package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping(value = "/user")
    public String showUser(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "/user/show";
    }
}
