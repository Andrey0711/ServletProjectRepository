package Validators;

import DTO.Person.CreatePersonDto;
import Utils.LocalDateFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public class CreatePersonValidator implements Validator<CreatePersonDto>{

    private final static CreatePersonValidator INSTANCE = new CreatePersonValidator();

    @Override
    public ValidationResult isValid(CreatePersonDto obj) {
        ValidationResult validationResult = new ValidationResult();
        if(LocalDateFormatter.isValid(obj.getBirthday())){
            validationResult.add(Error.of("invalid birthyear", "Birthyear is invalid"));
        }
        if(obj.getName() == null){
            validationResult.add(Error.of("invalid name", "Name is invalid"));
        }
        return validationResult;
    }

    public static CreatePersonValidator getInstance(){
        return INSTANCE;
    }
}
