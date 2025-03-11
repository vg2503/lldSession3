package parkingLotSystem;

import parkingLotSystem.DTO.IssueTicketRequestDTO;
import parkingLotSystem.DTO.IssueTicketResponseDTO;
import parkingLotSystem.controller.TicketController;
import parkingLotSystem.factory.SpotAssignmentStrategyFactory;
import parkingLotSystem.model.SpotAssignmentStrategyType;
import parkingLotSystem.model.VehicleType;
import parkingLotSystem.repository.GateRepository;
import parkingLotSystem.repository.ParkingLotRepository;
import parkingLotSystem.repository.VehicleRepository;
import parkingLotSystem.services.TicketService;
import parkingLotSystem.strategies.SpotAssignmentStrategy;

import java.util.Date;

public class ParkingLotMain {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(SpotAssignmentStrategyType.NEAREST);
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setEntryTime(new Date());
        requestDTO.setOperatorId(1L);
        requestDTO.setGateId(1L);
        requestDTO.setOwnerName("John");
        requestDTO.setVehicleType(VehicleType.BIKE);
        requestDTO.setVehicleName("KA01HU6446");
        IssueTicketResponseDTO responseDTO = ticketController.IssueTicket(requestDTO);
    }
}
