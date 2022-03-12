package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.request.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.response.FindUserResponse;
import africa.semicolon.sendAm.dtos.response.RegisterUserResponse;
import africa.semicolon.sendAm.services.UserServices;
import africa.semicolon.sendAm.services.UserServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")


public class UserController {
    private UserServices userService = new UserServicesImpl();

    @PostMapping("/register")
    public RegisterUserResponse registerNewUser(@RequestBody RegisterUserRequest request){
        return userService.register(request);
    }
    @GetMapping("/{email}")
    public FindUserResponse getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}
