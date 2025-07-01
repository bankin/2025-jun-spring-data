package bg.softuni.spring_data_intro.repositories;


import bg.softuni.spring_data_intro.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
