package ru.sbrf.server.processing.service;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.sbrf.server.processing.exception.CardNotFoundException;
import ru.sbrf.server.processing.exception.UserNotFoundException;
import ru.sbrf.server.processing.model.entity.Card;
import ru.sbrf.server.processing.model.mapper.CardMapper;
import ru.sbrf.server.processing.model.repository.CardCrudRepository;
import ru.sbrf.server.processing.model.transfer.CardDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CardService {
    private final CardCrudRepository cardCrudRepository;

    private final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    public CardDTO getCardById(Long id) {
        Card card = cardCrudRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return cardMapper.mapCardToCardDto(card);
    }

    public CardDTO getCardByCardNumber(String cardNumber) {
        Card card = cardCrudRepository
                .findByCardNumber(cardNumber)
                .orElseThrow(CardNotFoundException::new);
        return cardMapper.mapCardToCardDto(card);
    }

    public List<CardDTO> getAllUsers() {
        Iterable<Card> cardIterable = cardCrudRepository.findAll();
        List<CardDTO> cards = new ArrayList<>();

        cardIterable.forEach(card -> cards.add(cardMapper.mapCardToCardDto(card)));

        return cards;
    }
}
