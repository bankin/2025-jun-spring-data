package bg.softuni._18_json_exercise.repositories;

import bg.softuni._18_json_exercise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u " +
            "JOIN u.soldProducts AS sp " +
            "WHERE sp.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findWithSoldProductsOrderByLastName();

    @Query("SELECT u FROM User AS u " +
            "JOIN u.soldProducts AS sp " +
            "WHERE size(sp) > 0 " +
            "ORDER BY size(sp) DESC, u.lastName")
    List<User> findAllWithListedProducts();
}
