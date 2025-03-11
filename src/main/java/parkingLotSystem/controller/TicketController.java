package parkingLotSystem.controller;

import parkingLotSystem.DTO.IssueTicketRequestDTO;
import parkingLotSystem.DTO.IssueTicketResponseDTO;
import parkingLotSystem.DTO.ResponseStatus;
import parkingLotSystem.model.Ticket;
import parkingLotSystem.services.TicketService;

public class TicketController {
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO IssueTicket(IssueTicketRequestDTO requestDTO){
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{

            Ticket ticket = ticketService.issueTicket(
                    requestDTO.getEntryTime(),
                    requestDTO.getVehicleName(),
                    requestDTO.getGateId(),
                    requestDTO.getOperatorId(),
                    requestDTO.getVehicleType()
                    );
            responseDTO.setTicket(ticket);
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
