package bg.softuni._23_workshop.controllers;

import bg.softuni._23_workshop.dtos.UserLoginDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("users/login")
    public String loginView() {
        return "user/login";
    }

    @PostMapping("users/login")
    public String doLogin(@Valid UserLoginDTO loginData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // go back to login form
        }

        // go to db and validate login details
        // save logged user to ???

        // return "home" - this is bad because we don't know what data this template needs nor how to get it
        return "redirect:/home";
    }


}
