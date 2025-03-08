package Dao;

import DTO.TicketDto;
import Models.Ticket;
import Utils.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket>{

    private static final TicketDao INSTANCE = new TicketDao();

    private static final String SQL = """
    SELECT * 
    FROM ticket
    """;

    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM ticket WHERE id=?
            """;

    private TicketDao(){}

    public static TicketDao getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Ticket> findAll() {
        try(Connection connection = ConnectionManager.get()) {
            ResultSet resultSet = connection.prepareStatement(SQL).executeQuery();
            List<Ticket> ticketList = new ArrayList<>();
            while(resultSet.next()){
                ticketList.add(buildTicket(resultSet));
            }
            return ticketList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        try(Connection connection = ConnectionManager.get()) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Ticket> ticketList = new ArrayList<>();
            while(resultSet.next()){
                ticketList.add(buildTicket(resultSet));
            }
            return !ticketList.isEmpty() ? Optional.ofNullable(ticketList.getFirst()) : Optional.of(new Ticket());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }

    private static Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class)
        );
    }
}
