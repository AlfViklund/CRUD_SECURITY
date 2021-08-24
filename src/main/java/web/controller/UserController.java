package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Initializer;
import web.dao.UserDaoImpl;
import web.model.Role;
import web.model.User;
import web.service.RoleServiceImpl;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "/user/users";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("rolesList", roleService.getRolesList());
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("role") String roleName) {
        userService.addUserWithRole(user, roleName);
        return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("rolesList", roleService.getRolesList());
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam("role") String roleName) {
        //userService.update(user);
        userService.addUserWithRole(user, roleName);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/admin/users";
    }

}
