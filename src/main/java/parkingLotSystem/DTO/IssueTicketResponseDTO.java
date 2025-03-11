package parkingLotSystem.DTO;

import parkingLotSystem.model.Ticket;

public class IssueTicketResponseDTO extends BaseResponseDTO {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
