package Services;

import DTO.FlightDto;
import Dao.FlightDao;
import Models.Flight;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService(){}

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> findAll(){
        List<FlightDto> flightDtos = flightDao.findAll().stream().map(e -> FlightDto.builder()
                .id(e.getId())
                .description(
                """
                    %s - %s - %s
                """.formatted(
                        e.getDepartureAirportCode(),
                        e.getArrivalAirportCode(),
                        e.getStatus()))
                        .build())
                .collect(toList());
        System.out.println("FlightDto:" + flightDtos);
        return flightDtos;
    }

    public Optional<FlightDto> findById(Long id){
        Optional<Flight> tryGetFlight = flightDao.findById(id);
        return tryGetFlight.map(flight -> FlightDto.builder()
                .id(flight.getId())
                .description("""
                        %s - %s - %s
                        """.formatted(
                        flight.getDepartureAirportCode(),
                        flight.getArrivalAirportCode(),
                        flight.getStatus()
                ))
                .build());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
