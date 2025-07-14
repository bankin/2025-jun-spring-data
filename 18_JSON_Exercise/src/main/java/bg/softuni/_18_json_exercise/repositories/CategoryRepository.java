package bg.softuni._18_json_exercise.repositories;

import bg.softuni._18_json_exercise.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new bg.softuni._18_json_exercise.repositories.CategoryStatsProj(" +
                "c.name, count(p), avg(p.price), sum(p.price)) " +
            "FROM Category AS c " +
            "JOIN c.products AS p " +
            "GROUP BY c " +
            "ORDER BY count(p) DESC")
    List<CategoryStatsProj> findCategoryStats();
}
