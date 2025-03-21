package org.example.exchange.rate.exchangerateproject.Tools;

import org.example.exchange.rate.exchangerateproject.Utils.ConnectionManager;
import org.example.exchange.rate.exchangerateproject.Models.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private final static String SQL = """
            INSERT INTO currencies(code, full_name, sign) VALUES(?, ?, ?)
            """;
    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            GsonParser gsonParser = new GsonParser();
            List<Currency> currencyList = gsonParser.parse();
            for (Currency currency : currencyList) {
                preparedStatement.setObject(1, currency.getCode());
                preparedStatement.setObject(2, currency.getFullName());
                preparedStatement.setObject(3, currency.getSign());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
