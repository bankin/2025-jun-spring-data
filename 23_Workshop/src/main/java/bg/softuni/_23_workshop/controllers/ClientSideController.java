package bg.softuni._23_workshop.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

record UserDTO(@Min(20) long id, String name, int age) {
}

@RestController
public class ClientSideController {

    @GetMapping("/client/user")
    public String getUser() {
        return "this is user data?";
    }

    @GetMapping("/client/dto")
    public UserDTO getUserJsonData() {
        return new UserDTO(10, "Pesho", 22);
    }

    @PostMapping("/client/update")
    public String updateUser(@RequestBody @Valid UserDTO data) {
        return "success";
    }
}
