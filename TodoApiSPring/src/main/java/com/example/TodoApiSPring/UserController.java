package com.example.TodoApiSPring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public static String getUsers(){
        return "Users of the app";
    }
}
