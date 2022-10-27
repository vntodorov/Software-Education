package IteratorsAndComparatorsEXERCISES.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> lake;

    public Lake(Integer... elements) {
        this.lake = List.of(elements);
    }

    private class Frog implements Iterator<Integer> {

        private int index = 0;
        private boolean firstRoundFinished = false;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            Integer element = lake.get(index);
            index += 2;
            if (!hasNext() && !firstRoundFinished) {
                index = 1;
                firstRoundFinished = true;
            }
            return element;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
