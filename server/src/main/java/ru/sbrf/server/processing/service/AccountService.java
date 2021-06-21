package ru.sbrf.server.processing.service;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.sbrf.server.processing.exception.UserNotFoundException;
import ru.sbrf.server.processing.model.entity.Account;
import ru.sbrf.server.processing.model.mapper.AccountMapper;
import ru.sbrf.server.processing.model.repository.AccountCrudRepository;
import ru.sbrf.server.processing.model.transfer.AccountDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountCrudRepository accountCrudRepository;
    private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    public AccountDTO getAccount(Long id) {
        Account account = accountCrudRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return accountMapper.mapAccountToAccountDto(account);
    }

    public List<AccountDTO> getAllUsers() {
        Iterable<Account> accountIterable = accountCrudRepository.findAll();
        List<AccountDTO> accounts = new ArrayList<>();

        accountIterable.forEach(account -> accounts.add(accountMapper.mapAccountToAccountDto(account)));

        return accounts;
    }
}
