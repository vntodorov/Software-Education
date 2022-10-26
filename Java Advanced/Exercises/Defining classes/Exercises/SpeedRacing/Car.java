package DefiningClassesEXERCISES.SpeedRacing;

public class Car {

    private String model;

    private double fuel;

    private double fuelForKil;

    private int distanceTraveled;

    public Car(String model, double fuel, double fuelForKil) {
        this.model = model;
        this.fuel = fuel;
        this.fuelForKil = fuelForKil;
        this.distanceTraveled = 0;

    }

    public void drive(int amountOfKil) {
        double neededFuel = amountOfKil * this.fuelForKil;

        if (this.fuel >= neededFuel) {

            this.fuel -= neededFuel;
            distanceTraveled += amountOfKil;

        } else {

            System.out.println("Insufficient fuel for the drive");

        }


    }

    @Override
    public String toString(){

        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }


    public String getModel() {
        return this.model;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getFuelForKil() {
        return this.fuelForKil;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setFuelForKil(double fuelForKil) {
        this.fuelForKil = fuelForKil;
    }

}
