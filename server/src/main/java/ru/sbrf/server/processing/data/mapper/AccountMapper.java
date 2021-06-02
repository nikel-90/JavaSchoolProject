package ru.sbrf.server.processing.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.data.entity.Account;
import ru.sbrf.server.processing.data.transfer.AccountDTO;

@Mapper
public interface AccountMapper {
    /**
     * Преобразование объекта БД к формату ответа
     *
     * @param account - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "accountId", source = "account.accountId"),
            @Mapping(target = "accountNumber", source = "account.accountNumber"),
            @Mapping(target = "accountBalance", source = "account.accountBalance"),
            @Mapping(target = "userId", source = "account.userId"),
            @Mapping(target = "cardsDTO", source = "account.cardsDTO"),
    })
    AccountDTO mapAccountToAccountDto(Account account);

    /**
     * Преобразование accountDTO к обекту БД
     *
     * @param accountDTO - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "accountId", source = "accountDTO.accountId"),
            @Mapping(target = "accountNumber", source = "accountDTO.accountNumber"),
            @Mapping(target = "accountBalance", source = "accountDTO.accountBalance"),
            @Mapping(target = "userId", source = "accountDTO.userId"),
            @Mapping(target = "cardsDTO", source = "accountDTO.cardsDTO"),
    })
    Account mapAccountDtoToAccount(AccountDTO accountDTO);
}
