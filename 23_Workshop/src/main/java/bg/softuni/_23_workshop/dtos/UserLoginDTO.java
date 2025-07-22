package bg.softuni._23_workshop.dtos;

import jakarta.validation.constraints.Size;

public record UserLoginDTO(@Size(min = 3) String username, String password) {
}
