package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleServiceImpl;
import web.service.UserService;

@Component
public class Initializer {
    private final UserService userService;

    public Initializer(UserService userService) {
        this.userService = userService;
        InitializeUsers();
    }


    public void InitializeUsers() {
        userService.add(new User("admin", "Lastname", "admin", new Role("ROLE_ADMIN")));
        for(int i = 0; i <= 10; i++) {
            userService.addUserWithRole(new User("user" + i, "Lastname" + i, "user" + i), "ROLE_USER");
        }
    }
}
