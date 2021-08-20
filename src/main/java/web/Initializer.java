package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.UserService;

@Component
public class Initializer {
    private final UserService userService;
    private Role userRole = new Role("ROLE_USER");
    private final PasswordEncoder encoder;

    public Initializer(UserService userService, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.userService = userService;
        InitializeUsers();
    }


    public void InitializeUsers() {
        userService.add(new User("admin", "Lastname", encoder.encode("admin"), new Role("ROLE_ADMIN")));
        userService.add(new User("user", "Lastname", "{bcrypt}user", userRole));
//        userService.add(new User("Name2", "Lastname", "pass2", userRole));
//        userService.add(new User("Name3", "Lastname", "pass3", userRole));
//        userService.add(new User("Name666", "Lastname", "pass4", userRole));
    }
}
