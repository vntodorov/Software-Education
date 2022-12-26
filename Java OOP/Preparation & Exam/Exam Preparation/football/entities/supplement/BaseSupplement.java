package ExamPreparation.football.entities.supplement;

public abstract class BaseSupplement implements Supplement {

    private int energy;

    private double price;

    protected BaseSupplement(int energy, double price){
        this.energy = energy;
        this.price = price;
    }

    public int getEnergy(){
        return energy;
    }

    public double getPrice(){
        return price;
    }

}
