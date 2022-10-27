package IteratorsAndComparatorsEXERCISES.Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
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

    public boolean hasNext() {
        return index + 1 < elements.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int internalIndex;

            @Override
            public boolean hasNext() {
                return internalIndex < elements.size() - 1;
            }

            @Override
            public String next() {
                String element = elements.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }

    public void PrintAll() {
        String result = String.join(" ", elements);
        System.out.printf("%s%n", result);
    }
}
