package parkingLotSystem.services;

import parkingLotSystem.exceptions.InvalidGateException;
import parkingLotSystem.exceptions.InvalidParkingLotException;
import parkingLotSystem.exceptions.InvalidVehicleException;
import parkingLotSystem.model.*;
import parkingLotSystem.repository.GateRepository;
import parkingLotSystem.repository.ParkingLotRepository;
import parkingLotSystem.repository.VehicleRepository;
import parkingLotSystem.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private  final  GateRepository gateRepository;
    private final  VehicleRepository vehicleRepository;
    private final  ParkingLotRepository parkingLotRepository;
    private final SpotAssignmentStrategy spotAssignmentStrategy;
    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public Ticket issueTicket(Date entryTime, String vehicleNumber, Long gateId, Long operatorId,
                              VehicleType vehicleType)
            throws InvalidGateException, InvalidParkingLotException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(entryTime);

        //get the vehicle from repository
        Vehicle vehicle = null;
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleById(vehicleNumber);
        if(optionalVehicle.isEmpty()) {
            //need to add vehicle to the db
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }
        else{
            vehicle = optionalVehicle.get();
        }

        //get the Gate from repo
        Optional<Gate> optionalGate = gateRepository.getGateById(gateId);
        if(optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate id provided");
        }
        Gate gate = optionalGate.get();

        //get the operator from repo
        Operator operator = gate.getOperator();


        //need to assign the parking spot


        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotIdByGateId(gate.getId());
        if(optionalParkingLot.isEmpty()) {
            throw new InvalidParkingLotException("Invalid Parking Lot");
        }
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, optionalParkingLot.get());


        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
}
