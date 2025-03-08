package Services;

import DTO.Person.CreatePersonDto;
import Dao.PersonDao;
import Mapper.CreatePersonMapper;
import Models.Person;
import Validators.CreatePersonValidator;
import Validators.ValidationResult;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PersonService {

    private final PersonDao personDao = PersonDao.getInstance();
    private final CreatePersonValidator personValidator = CreatePersonValidator.getInstance();
    private final CreatePersonMapper personMapper = CreatePersonMapper.getInstance();

    private static final PersonService INSTANCE = new PersonService();

    public Long save(CreatePersonDto entity){
        ValidationResult validationResult = personValidator.isValid(entity);
        if(validationResult.isValid()){}
        return null;
    }

    public static PersonService getInstance(){
        return INSTANCE;
    }

}
