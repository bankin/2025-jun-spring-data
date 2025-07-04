package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working...");

        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        String[] names = scanner.nextLine().split(",");
//        int count = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());

//        List<Shampoo> shampoos = shampooService.findByIngredientCount(count);
//        shampoos.forEach(System.out::println);

//        List<Ingredient> ingredients = ingredientService.findAll(names);
//        ingredients.forEach(System.out::println);

//        int count = shampooService.countCheaperThan(price);
//        System.out.println(count);

//        ingredientService.delete(name);

        ingredientService.updatePrice(price);
    }
}
