package com.example.advquerying.services;


import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooService(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    public List<Shampoo> getShampooBySize(String input) {
        Size size = Size.valueOf(input);

        return shampooRepository.findBySizeOrderByBrandDesc(size);
    }

    public List<Shampoo> getShampooBySizeOrLabel(String inputSize, int labelId) {
        Size size = Size.valueOf(inputSize);
        // Size value is wrong?? try/catch?!

        return shampooRepository.findBySizeOrLabelId(size, labelId);

        // Data transformation - show only brand, size, price?
    }

    public List<Shampoo> getMoreExpensive(int price) {
        if (price < 0) {
            // ???
        }

        return shampooRepository.findByPriceGreaterThanOrderByPriceDescBrand(BigDecimal.valueOf(price));
    }

    public int countCheaperThan(double price) {
        return shampooRepository.countByPriceLessThan(BigDecimal.valueOf(price));
    }

    public List<Shampoo> findByIngredients(String[] names) {
        List<String> ingredientNames = Arrays.asList(names);

        return shampooRepository.findByIngredientsNameInQuery(ingredientNames);
    }

    public List<Shampoo> findByIngredientCount(int count) {
        return shampooRepository.findByIngredientsCountLessThan(count);
    }
}
