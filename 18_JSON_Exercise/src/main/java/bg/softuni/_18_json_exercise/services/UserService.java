package bg.softuni._18_json_exercise.services;

import bg.softuni._18_json_exercise.dtos.ImportUserDTO;
import bg.softuni._18_json_exercise.dtos.UserWithListProductsDTO;
import bg.softuni._18_json_exercise.dtos.UserWithSoldProductsDTO;
import bg.softuni._18_json_exercise.entities.Product;
import bg.softuni._18_json_exercise.entities.User;
import bg.softuni._18_json_exercise.repositories.ProductRepository;
import bg.softuni._18_json_exercise.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private Gson gson;
    private ModelMapper mapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
    }

    public void getAllWithListedProducts() {
        List<User> allWithListedProducts = this.userRepository.findAllWithListedProducts();

        UserWithListProductsDTO[] result = this.mapper
                .map(allWithListedProducts, UserWithListProductsDTO[].class);

        String json = this.gson.toJson(result);

        System.out.println(json);
    }

    public void getAllWithSoldProducts() {
        List<User> users = this.userRepository.findWithSoldProductsOrderByLastName();

        for (User user : users) {
            List<Product> soldProducts = this.productRepository.findBySellerAndBuyerIsNotNull(user);
            user.setSoldProducts(soldProducts);
        }

        UserWithSoldProductsDTO[] result = this.mapper.map(users, UserWithSoldProductsDTO[].class);

        String json = this.gson.toJson(result);

        System.out.println(json);
    }

    public void importData() throws IOException {
        // Read JSON -> DTO
        Path fileLocation = Path.of("src/main/resources/jsons/users.json");
        List<String> lines = Files.readAllLines(fileLocation);

        ImportUserDTO[] fromJson =
            this.gson.fromJson(String.join("", lines), ImportUserDTO[].class);

        for (ImportUserDTO importUserDTO : fromJson) {
            // Validate
            if (importUserDTO.getLastName() == null || importUserDTO.getLastName().length() < 3) {
                System.out.println("User lastName is invalid");
                continue;
            }

            // DTO -> Entity
            User user = this.mapper.map(importUserDTO, User.class);

            // Persist
            this.userRepository.save(user);
        }
    }

    public User getRandomUser() {
        Random rand = new Random();

        long total = this.userRepository.count();

        if (total == 0) {
            return null;
        }

        while (true) {
            long id = rand.nextLong(total) + 1;

            Optional<User> user = this.userRepository.findById(id);

            if (user.isPresent()) {
                return user.get();
            }
        }
    }
}
