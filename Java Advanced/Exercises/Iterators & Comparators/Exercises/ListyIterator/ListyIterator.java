package IteratorsAndComparatorsEXERCISES.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {

    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.index = 0;
    }

    public boolean Move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void Print() {
        if (index < elements.size()) {
            System.out.println(elements.get(index));
        } else {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
    }


    @Override
    public boolean hasNext() {
        return index + 1 < elements.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return elements.get(index++);
        }
        return null;
    }
}
