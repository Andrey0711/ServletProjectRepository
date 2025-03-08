package Models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Flight {
    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private Long departureAirportCode;
    private LocalDateTime arrivalDate;
    private Long arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatus status;

}
