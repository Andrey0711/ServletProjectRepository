package Dao;

import DTO.FlightDto;
import Models.Flight;
import Models.FlightStatus;
import Utils.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT * 
            FROM flight
            """;

    private static final String FIND_BY_ID = """
            SELECT * FROM flight WHERE id=?
            """;

    private FlightDao(){}

    @SneakyThrows
    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Flight> flightList = new ArrayList<>();
            while (resultSet.next()) {
                flightList.add(buildFlight(resultSet));
            }
            return flightList;
        }
    }


    @Override
    public Optional<Flight> findById(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Flight> flightList = new ArrayList<>();
            while(resultSet.next()){
                flightList.add(buildFlight(resultSet));
            }
            return !flightList.isEmpty() ? Optional.of(flightList.getFirst()) : Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }


    public static FlightDao getInstance(){
        return INSTANCE;
    }



    @SneakyThrows
    private static Flight buildFlight(ResultSet resultSet) {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", LocalDateTime.class),
                resultSet.getObject("departure_airport_code", Long.class),
                resultSet.getObject("arrival_date", LocalDateTime.class),
                resultSet.getObject("arrival_airport_code", Long.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}




