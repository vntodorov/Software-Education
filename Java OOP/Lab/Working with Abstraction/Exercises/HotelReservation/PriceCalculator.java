package WorkingWithAbstractionLAB.HotelReservation;

public class PriceCalculator {

    public static double calculate(double pricePerDay, int days, Season season, DiscountType discountType){

        double priceForAllDays = (pricePerDay * season.getMultiplyCoefficient()) * days;
        priceForAllDays -= priceForAllDays * discountType.getPercent() / 100;

        return priceForAllDays;

    }
}
