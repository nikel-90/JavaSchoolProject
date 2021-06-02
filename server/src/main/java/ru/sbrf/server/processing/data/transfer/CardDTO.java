package ru.sbrf.server.processing.data.transfer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class CardDTO {

    private final long cardId;

    @NotBlank(message = "Необходимо указать номер карты")
    private final int cardNumber;

    @Past(message = "Дата окончания срока действия карты не должно быть меньше текущей даты")
    private final LocalDate expirationDate;

    @NotBlank(message = "Необходимо указать пин-код")
    private final int PIN;

    @NotBlank(message = "Необходимо указать CVV")
    private final int CVV;
}
