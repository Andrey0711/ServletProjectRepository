package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;
    private String passenger_no;
    private String passenger_name;
    private Long flight_id;
    private String seat_no;
    private BigDecimal cost;

}
