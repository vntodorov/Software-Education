package ExamPreparation.EasterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private List<Egg> data;

    private String material;

    private int capacity;

    public Basket(String material, int capacity){
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg){

        if (data.size() < capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){

        for (Egg egg : data){
            if (egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }

        return false;
    }

    public Egg getStrongestEgg(){

        return data.stream().sorted((f,s) -> Integer.compare(s.getStrength(), f.getStrength())).collect(Collectors.toList()).get(0);

    }

    public Egg getEgg(String color){

        for (Egg egg : data){
            if (egg.getColor().equals(color)){
                return egg;
            }
        }

        throw new NullPointerException("No egg with such color!");
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s basket contains:", this.material));
        report.append(System.lineSeparator());

        for (int i = 0; i < data.size(); i++) {
            report.append(data.get(i));
            if (i != data.size() - 1){
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }
}
