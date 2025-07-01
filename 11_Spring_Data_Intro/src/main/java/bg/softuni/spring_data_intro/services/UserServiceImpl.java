package bg.softuni.spring_data_intro.services;

import bg.softuni.spring_data_intro.entities.Account;
import bg.softuni.spring_data_intro.entities.User;
import bg.softuni.spring_data_intro.repositories.AccountRepository;
import bg.softuni.spring_data_intro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registerUser(User user) {
        // Convert data to User
        // Validation
        // Check if username is taken

        Account account = new Account();
        user.addAccount(account);

        userRepository.save(user);
    }

    @Override
    public Optional<User> find(String username) {
        return userRepository.findByUsername(username);
    }
}
