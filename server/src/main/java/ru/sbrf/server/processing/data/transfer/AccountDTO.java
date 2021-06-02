package ru.sbrf.server.processing.data.transfer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.sbrf.server.processing.data.entity.User;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@RequiredArgsConstructor
@Getter
//@Data
//@AllArgsConstructor
public class AccountDTO {

    private final Long accountId;

    @NotBlank(message = "Необходимо указать номер лицевого счета")
    private final String accountNumber;

    @NotBlank(message = "Необходимо указать номер баланс счета")
    private final BigDecimal accountBalance;

    private final User userId;

    private final Set<CardDTO> cardsDTO;
}

