package org.example.exchange.rate.exchangerateproject.Tools;

import com.google.gson.Gson;
import org.example.exchange.rate.exchangerateproject.Models.Currency;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GsonParser {
    public List<Currency> parse() {
        try (FileReader fileReader = new FileReader("C:\\Users\\User\\IdeaProjects\\ExchangeRateProject\\src\\main\\resources\\currencies.json")) {
            Gson gson = new Gson();
            Root root = gson.fromJson(fileReader, Root.class);
            return root.getCurrencyList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
