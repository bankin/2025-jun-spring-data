package bg.softuni._18_json_exercise.repositories;

import bg.softuni._18_json_exercise.entities.Product;
import bg.softuni._18_json_exercise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal lower, BigDecimal upper);

    List<Product> findBySellerAndBuyerIsNotNull(User seller);
}
