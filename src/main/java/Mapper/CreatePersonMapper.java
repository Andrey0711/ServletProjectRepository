package Mapper;

import DTO.Person.CreatePersonDto;
import Models.Gender;
import Models.Person;
import Models.Role;
import Utils.LocalDateFormatter;

public class CreatePersonMapper implements Mapper<CreatePersonDto, Person>{

    private static final CreatePersonMapper INSTANCE = new CreatePersonMapper();

    @Override
    public Person mapFrom(CreatePersonDto obj) {
        return Person.builder()
                .name(obj.getName())
                .email(obj.getEmail())
                .password(obj.getPassword())
                .gender(Gender.valueOf(obj.getGender()))
                .role(Role.valueOf(obj.getRole()))
                .birthday(LocalDateFormatter.format(obj.getBirthday()))
                .build();
    }

    public static CreatePersonMapper getInstance(){
        return INSTANCE;
    }
}
