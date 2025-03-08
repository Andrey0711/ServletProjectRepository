package Services;

import DTO.Person.CreatePersonDto;
import Dao.PersonDao;
import Models.Person;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PersonService {

    private final PersonDao personDao = PersonDao.getInstance();

    private static final PersonService INSTANCE = new PersonService();

    public Long save(CreatePersonDto entity){
        return buildService(personDao.save(en));
    }

    public PersonService getInstance(){
        return INSTANCE;
    }

    private Person buildService(CreatePersonDto person){
        return Person.builder()
                    .id(Long.valueOf(person.getId()))
                    .name(person.getName())
                    .birthday(person.getBirthday())
                    .email(person.getEmail())
                    .password(person.getPassword())
                    .role(person.getRole())
                    .gender(person.getGender())
                .build();
    }
}
