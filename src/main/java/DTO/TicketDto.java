package DTO;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class TicketDto {
    Long id;
    String passenger_name;
    BigDecimal cost;
}
