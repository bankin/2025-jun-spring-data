package bg.softuni._18_json_exercise.services;

import bg.softuni._18_json_exercise.dtos.CategoryStatsDTO;
import bg.softuni._18_json_exercise.dtos.ImportCategoryDTO;
import bg.softuni._18_json_exercise.entities.Category;
import bg.softuni._18_json_exercise.repositories.CategoryRepository;
import bg.softuni._18_json_exercise.repositories.CategoryStatsProj;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryService {
    private final Gson gson;
    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
    }


    public void getCategoryStats() {
        List<CategoryStatsProj> categoryStats = this.categoryRepository.findCategoryStats();

        CategoryStatsDTO[] result = this.mapper.map(categoryStats, CategoryStatsDTO[].class);

        String json = this.gson.toJson(result);

        System.out.println(json);
    }

    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/jsons/categories.json");
        List<String> lines = Files.readAllLines(path);

        ImportCategoryDTO[] input = this.gson.fromJson(
            String.join("", lines), ImportCategoryDTO[].class);

        for (ImportCategoryDTO importCategoryDTO : input) {
            String name = importCategoryDTO.getName();
            if (name == null || name.length() < 3 || name.length() > 15) {
                System.out.println("Invalid category name " + name);

                continue;
            }

            Category category = new Category(name);

            this.categoryRepository.save(category);
        }
    }

    public Set<Category> getRandomCategories() {
        Random rand = new Random();

        long total = this.categoryRepository.count();
        long count = rand.nextLong(total);

        Set<Category> result = new HashSet<>();
        for (int i = 0; i < count; i++) {
            long id = rand.nextLong(total) + 1;
            Optional<Category> category = this.categoryRepository.findById(id);

            category.ifPresent(result::add);
        }

        return result;
    }
}
