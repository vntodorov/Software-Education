package InterfacesAndAbstractionLAB.CarShopExtended;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;

    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());

        out.append(System.lineSeparator());
        out.append(String.format("Minimum rental period of %d days. Price per day %f", minRentDay, pricePerDay));

        return out.toString();
    }
}
