package E00_Accounts.services;

import E00_Accounts.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import E00_Accounts.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Optional<Account> account = accountRepository.findAccountById(id);
        BigDecimal currentBalance = accountRepository.getById(id).getBalance();

        if(account.isPresent() && currentBalance.compareTo(BigDecimal.ZERO) > 0) {
            accountRepository.getById(id).setBalance(currentBalance.subtract(money));
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isPresent() && money.floatValue() >= 0) {
            accountRepository.getById(id).setBalance(money);
        }
    }
}
