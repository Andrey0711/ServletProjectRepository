package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    Long id;
    String name;
    LocalDate birthday;
    String email;
    String password;
    Role role;
    Gender gender;

}
