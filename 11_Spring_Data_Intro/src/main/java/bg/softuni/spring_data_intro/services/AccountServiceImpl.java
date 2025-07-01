package bg.softuni.spring_data_intro.services;

import bg.softuni.spring_data_intro.entities.Account;
import bg.softuni.spring_data_intro.entities.User;
import bg.softuni.spring_data_intro.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdrawMoney(BigDecimal amount, long id) {
//        Account account = getAccountOrThrow(id);
        Optional<Account> byId = accountRepository.findById(id);

        if (byId.isEmpty()) {
            throw new RuntimeException("Missing Account");
        }

        Account account = byId.get();

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient Funds");
        }

        BigDecimal newBalance = account.getBalance().subtract(amount);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }

    public void transferMoney(BigDecimal amount, User user, long accountId) {
        // accounts is a lazy collection
//        boolean hasAccount = user.getAccounts()
//                .stream()
//                .anyMatch(a -> a.getId() == accountId);

        // assert if the account belongs to the user
//        Optional<Account> account = accountRepository.findById(accountId);
//        account.getUser.getId == user.get()

        Account account = getAccountOrThrow(accountId);

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Cannot transfer negative amounts");
        }

        BigDecimal newBalance = account.getBalance().subtract(amount);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }

    private Account getAccountOrThrow(long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missing Account"));
    }
}
