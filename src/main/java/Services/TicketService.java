package Services;

import DTO.TicketDto;
import Dao.TicketDao;
import Models.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TicketService {
    private static final TicketDao ticketDao = TicketDao.getInstance();
    private static final TicketService INSTANCE = new TicketService();

    private TicketService(){}

    public List<TicketDto> findAll(){
        return ticketDao.findAll().stream().map(e -> TicketDto.builder()
                .id(e.getId())
                .cost(e.getCost())
                .passenger_name(e.getPassenger_name())
                .build())
                .collect(toList());
    }

    public TicketDto findById(Long id) {
        Optional<Ticket> tryGetTicket = ticketDao.findById(id);
        if(tryGetTicket.isPresent()){
            return TicketDto.builder()
                    .id(tryGetTicket.get().getId())
                    .passenger_name(tryGetTicket.get().getPassenger_name())
                    .cost(tryGetTicket.get().getCost())
                    .build();
        }
        throw new RuntimeException("Ticket was not found");
    }

    public static TicketService getInstance(){
        return INSTANCE;
    }

}
