package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public List<Ingredient> getAutocompleteOptions(String start) {
        // Validate start length?

        return ingredientRepository.findByNameStartingWith(start);
    }


    public List<Ingredient> findAll(String[] names) {
        List<String> input = Arrays.asList(names);

        return ingredientRepository.findByNameInOrderByPrice(input);
    }

    @Transactional
    public void delete(String name) {
        // getTransaction().begin();
        ingredientRepository.deleteByName(name);
        // getTransaction().commit();
        // catch -> getTransaction.rollback();
    }

    public void updatePrice(double price) {
        // Fix percent to be 1 + [0; 1]
        ingredientRepository.updatePriceByPercent(price);
    }
}
