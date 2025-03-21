package org.example.exchange.rate.exchangerateproject.Mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.exchange.rate.exchangerateproject.Models.Currency;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyMapper implements Mapper<Currency, Currency> {

    @Override
    public Currency mapFrom(Currency obj) {
        return Currency.builder()
                    .code(obj.getCode())
                    .sign(obj.getSign())
                    .fullName(obj.getFullName())
                .build();
    }
}
