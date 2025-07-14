package bg.softuni._18_json_exercise;

import bg.softuni._18_json_exercise.services.CategoryService;
import bg.softuni._18_json_exercise.services.ProductService;
import bg.softuni._18_json_exercise.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public Runner(
            UserService userService,
            CategoryService categoryService,
            ProductService productService
    ) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working...");


//        productService.getUnsoldProductsInRange(500, 1000);
        userService.getAllWithListedProducts();
//        categoryService.getCategoryStats();
    }
}
