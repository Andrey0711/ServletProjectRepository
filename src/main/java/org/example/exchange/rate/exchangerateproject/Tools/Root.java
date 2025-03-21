package org.example.exchange.rate.exchangerateproject.Tools;

import lombok.Data;
import org.example.exchange.rate.exchangerateproject.Models.Currency;

import java.util.List;

@Data
public class Root {
    List<Currency> currencyList;
}
