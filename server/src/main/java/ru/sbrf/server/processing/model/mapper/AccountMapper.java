package ru.sbrf.server.processing.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.model.entity.Account;
import ru.sbrf.server.processing.model.transfer.AccountDTO;

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
            @Mapping(target = "id", source = "account.id"),
            @Mapping(target = "accountNumber", source = "account.accountNumber"),
            @Mapping(target = "accountBalance", source = "account.accountBalance"),
            @Mapping(target = "userId", source = "account.user_id"),
            @Mapping(target = "cards", source = "account.cards"),
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
            @Mapping(target = "id", source = "accountDTO.id"),
            @Mapping(target = "accountNumber", source = "accountDTO.accountNumber"),
            @Mapping(target = "accountBalance", source = "accountDTO.accountBalance"),
            @Mapping(target = "user_id", source = "accountDTO.userId"),
            @Mapping(target = "cards", source = "accountDTO.cards"),
    })
    Account mapAccountDtoToAccount(AccountDTO accountDTO);
}
