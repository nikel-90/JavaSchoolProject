package ru.sbrf.server.processing.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.data.entity.Card;
import ru.sbrf.server.processing.data.transfer.CardDTO;

@Mapper
public interface CardMapper {
    /**
     * Преобразование объекта БД к формату ответа
     *
     * @param card - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "cardNumber", source = "user.cardNumber"),
            @Mapping(target = "expirationDate", source = "user.expirationDate"),
            @Mapping(target = "PIN", source = "user.PIN"),
            @Mapping(target = "CVV", source = "user.CVV"),
            @Mapping(target = "accountId", source = "user.accountId"),
    })
    CardDTO mapCardToCardDto(Card card);

    /**
     * Преобразование cardDTO к обекту БД
     *
     * @param cardDTO - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "cardNumber", source = "user.cardNumber"),
            @Mapping(target = "expirationDate", source = "user.expirationDate"),
            @Mapping(target = "PIN", source = "user.PIN"),
            @Mapping(target = "CVV", source = "user.CVV"),
            @Mapping(target = "accountId", source = "user.accountId"),
    })
    Card mapCardDtoToCard(CardDTO cardDTO);
}
