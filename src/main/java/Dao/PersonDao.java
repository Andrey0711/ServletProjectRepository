package Dao;

import Models.Person;
import Utils.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.*;

public class PersonDao implements Dao<Long, Person>{

    private static final PersonDao INSTANCE = new PersonDao();

    private final String SAVE_SQL = """
            INSERT INTO person(name, birthday, email, password, role, gender)\s
            VALUES(?, ?, ?, ?, ?, ?)
           \s""";

    private PersonDao(){}

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Person entity) {

    }

    @Override
    @SneakyThrows
    public Person save(Person entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole());
            preparedStatement.setObject(6, entity.getGender());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Long.class));
            return entity;
        }
    }

    public static PersonDao getInstance(){
        return INSTANCE;
    }
}
