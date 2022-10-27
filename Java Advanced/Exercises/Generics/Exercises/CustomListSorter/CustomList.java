package GenericsEXERCISES.CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T swap = values.get(firstIndex);
        values.set(firstIndex, values.get(secondIndex));
        values.set(secondIndex, swap);
    }

    public int countGreaterThan(T elementToCompare) {
        return (int) values.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    public T getMax() {
        return values.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return values.stream().min(Comparable::compareTo).get();
    }

    public int size(){
        return values.size();
    }

    public T get(int index){
        return values.get(index);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (T element : values){
            sb.append(element.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
