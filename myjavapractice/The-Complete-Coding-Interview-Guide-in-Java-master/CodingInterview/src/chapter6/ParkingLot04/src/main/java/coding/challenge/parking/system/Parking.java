package chapter6.ParkingLot04.src.main.java.coding.challenge.parking.system;
 
import chapter6.ParkingLot04.src.main.java.coding.challenge.parking.ParkingTicket;
import chapter6.ParkingLot04.src.main.java.coding.challenge.parking.VehicleType;

public interface Parking {
    
    public ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type);
    public boolean unparkVehicleBtn(String licensePlate, VehicleType type);
    public boolean unparkVehicleBtn(ParkingTicket parkingTicket);        
}
