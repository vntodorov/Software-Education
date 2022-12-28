package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends PassengerVehicle{
    private static final String CAR_TYPE = "CAR";

    public Car(){
        super(CAR_TYPE);
    }

    public Car(String model, String fuelType, int seats){
        this();
        this.model = model;
        this.fieldType = fuelType;
        this.seats = seats;
    }


}
