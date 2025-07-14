package bg.softuni._18_json_exercise.services;

import bg.softuni._18_json_exercise.dtos.ImportProductDTO;
import bg.softuni._18_json_exercise.dtos.UnsoldProductInfoDTO;
import bg.softuni._18_json_exercise.entities.Product;
import bg.softuni._18_json_exercise.entities.User;
import bg.softuni._18_json_exercise.repositories.ProductRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private Gson gson;
    private ModelMapper mapper;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductService(
            ProductRepository productRepository,
            UserService userService,
            CategoryService categoryService
    ) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
    }

    public void getUnsoldProductsInRange(double lower, double upper) {
        BigDecimal low = BigDecimal.valueOf(lower);
        BigDecimal high = BigDecimal.valueOf(upper);
        List<Product> products =
            this.productRepository.findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(low, high);

        List<UnsoldProductInfoDTO> result = new ArrayList<>();

        for (Product product : products) {
            result.add(new UnsoldProductInfoDTO(product));
        }

        String json = this.gson.toJson(result);

        System.out.println(json);
    }

    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/jsons/products.json");
        List<String> lines = Files.readAllLines(path);

        ImportProductDTO[] data = this.gson.fromJson(
            String.join("", lines), ImportProductDTO[].class);

        for (ImportProductDTO dto : data) {
            String name = dto.getName();
            if (name == null || name.length() < 3) {
                System.out.println("Invalid product name " + name);

                continue;
            }

            Product product = this.mapper.map(dto, Product.class);

            product.setSeller(this.getRandomUser(false));
            product.setBuyer(this.getRandomUser(true));
            product.setCategories(this.categoryService.getRandomCategories());

            this.productRepository.save(product);
        }

    }

    private User getRandomUser(boolean canReturnNull) {
        Random rand = new Random();

        if (canReturnNull) {
            boolean nullResult = rand.nextBoolean();

            if (nullResult) {
                return null;
            }
        }

        return this.userService.getRandomUser();
    }
}
