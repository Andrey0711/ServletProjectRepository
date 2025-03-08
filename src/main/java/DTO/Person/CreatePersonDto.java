package DTO.Person;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreatePersonDto {
    String id;
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
