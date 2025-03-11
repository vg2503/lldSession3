package parkingLotSystem.repository;

import parkingLotSystem.model.Gate;
import parkingLotSystem.model.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private final Map<Long, Ticket> ticketMap;
    public TicketRepository() {
        ticketMap = new HashMap<>();
    }

    public Ticket save(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketById(long id) {
        if(ticketMap.containsKey(id)) {
            return Optional.ofNullable(ticketMap.get(id));
        }
        return Optional.empty();
    }
}
