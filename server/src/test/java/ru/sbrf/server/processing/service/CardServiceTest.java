package ru.sbrf.server.processing.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sbrf.server.processing.model.entity.Card;
import ru.sbrf.server.processing.model.mapper.CardMapper;
import ru.sbrf.server.processing.model.repository.CardCrudRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {
    private final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    @Mock
    private CardCrudRepository cardCrudRepository;

    @InjectMocks
    private CardService cardService;

    private Long cardId;
    private String cardNumber;

    @Before
    public void setUp() {
        cardId = 1L;
        cardNumber = "1234";
    }

    @Test
    public void getCardByID() {
        Card card = new Card();
        card.setId(cardId);

        when(cardCrudRepository.findById(cardId)).thenReturn(java.util.Optional.of(card));
        assertEquals(cardService.getCardById(cardId), cardMapper.mapCardToCardDto(card));
    }

    @Test
    public void getCardByCardNumber() {
        Card card = new Card();
        card.setCardNumber(cardNumber);

        when(cardCrudRepository.findByCardNumber(cardNumber)).thenReturn(java.util.Optional.of(card));
        assertEquals(cardService.getCardByCardNumber(cardNumber), cardMapper.mapCardToCardDto(card));
    }

    @Test
    public void getAllUsers() {
        Card card = new Card();
        Card card1 = new Card();

        List<Card> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card1);

        when(cardCrudRepository.findAll()).thenReturn(cards);
        assertNotNull(cardService.getAllUsers());
    }
}