package DefiningClassesLAB.CarInfo;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Car(String brand, String model, int horsePower) {

        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;


    }

    public void carInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n", this.brand, this.model, this.horsePower);

    }


}
