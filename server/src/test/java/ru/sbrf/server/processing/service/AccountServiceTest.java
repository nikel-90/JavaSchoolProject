package ru.sbrf.server.processing.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sbrf.server.processing.model.entity.Account;
import ru.sbrf.server.processing.model.mapper.AccountMapper;
import ru.sbrf.server.processing.model.repository.AccountCrudRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
    @Mock
    AccountCrudRepository accountCrudRepository;

    @InjectMocks
    AccountService accountService;

    private Long accountId;

    @Before
    public void setUp() {
        accountId = 1L;
    }

    @Test
    public void getAccountByID() {
        Account account = new Account();
        account.setId(accountId);

        when(accountCrudRepository.findById(accountId)).thenReturn(java.util.Optional.of(account));
        assertEquals(accountService.getAccount(accountId), accountMapper.mapAccountToAccountDto(account));
    }
}
