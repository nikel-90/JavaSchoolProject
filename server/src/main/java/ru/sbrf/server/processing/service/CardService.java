package ru.sbrf.server.processing.service;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.sbrf.server.processing.data.entity.Card;
import ru.sbrf.server.processing.data.mapper.CardMapper;
import ru.sbrf.server.processing.data.repository.CardCrudRepository;
import ru.sbrf.server.processing.data.transfer.CardDTO;
import ru.sbrf.server.processing.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

//@Service
//@AllArgsConstructor
//public class CardService {
//
//    private final CardCrudRepository cardCrudRepository;
//    private final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);
//
//    public CardDTO getCard(Long id) {
//        Card card = cardCrudRepository.findById(id)
//                .orElseThrow(UserNotFoundException::new);
//        return cardMapper.mapCardToCardDto(card);
//    }
//
//    public List<CardDTO> getAllUsers() {
//        Iterable<Card> cardIterable = cardCrudRepository.findAll();
//        List<CardDTO> cards = new ArrayList<>();
//
//        cardIterable.forEach(card -> cards.add(cardMapper.mapCardToCardDto(card)));
//
//        return cards;
//    }
//}
