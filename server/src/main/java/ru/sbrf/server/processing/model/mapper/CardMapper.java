package ru.sbrf.server.processing.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.model.entity.Card;
import ru.sbrf.server.processing.model.transfer.CardDTO;

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
            @Mapping(target = "cardId", source = "card.id"),
            @Mapping(target = "cardNumber", source = "card.cardNumber"),
            @Mapping(target = "expirationDate", source = "card.expirationDate"),
            @Mapping(target = "PIN", source = "card.PIN"),
            @Mapping(target = "CVV", source = "card.CVV"),
            @Mapping(target = "account_id", source = "card.account_id"),
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
            @Mapping(target = "id", source = "cardDTO.cardId"),
            @Mapping(target = "cardNumber", source = "cardDTO.cardNumber"),
            @Mapping(target = "expirationDate", source = "cardDTO.expirationDate"),
            @Mapping(target = "PIN", source = "cardDTO.PIN"),
            @Mapping(target = "CVV", source = "cardDTO.CVV"),
            @Mapping(target = "account_id", source = "cardDTO.account_id"),
    })
    Card mapCardDtoToCard(CardDTO cardDTO);
}
