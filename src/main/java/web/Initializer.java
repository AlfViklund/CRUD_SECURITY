package web;

import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

@Component
public class Initializer {
    private final UserService userService;

    public Initializer(UserService userService) {
        this.userService = userService;
        InitializeUsers();
    }


    public void InitializeUsers() {
        userService.add(new User("Name", "Lastname", "email"));
        userService.add(new User("Name", "Lastname", "email"));
        userService.add(new User("Name", "Lastname", "email"));
        userService.add(new User("Name", "Lastname", "email"));
        userService.add(new User("Name666", "Lastname", "email"));
    }
}
