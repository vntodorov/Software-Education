package GenericsEXERCISES.GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = values.get(firstIndex);
        T secondElement = values.get(secondIndex);
        values.set(firstIndex, secondElement);
        values.set(secondIndex, firstElement);
    }

    public int countOfGreaterItems(T elementToCompare){
        return (int) values.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }

        return sb.toString();
    }
}
