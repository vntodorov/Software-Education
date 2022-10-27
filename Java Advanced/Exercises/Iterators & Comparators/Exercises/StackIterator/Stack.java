package IteratorsAndComparatorsEXERCISES.StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    private ArrayDeque<Integer> data;
    private ArrayDeque<Integer> archive;

    public Stack() {
        data = new ArrayDeque<>();
        archive = new ArrayDeque<>();
    }

    private class StackIterator implements Iterator<Integer> {

        private int index = 0;
        private boolean isFirstFinished = false;

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public Integer next() {
            archive.push(data.peek());
            int element = data.pop();
            if (index == data.size() && !isFirstFinished){
                isFirstFinished = true;
                for (int num : archive){
                    data.push(num);
                }
            }
            return element;
        }
    }


    public void push(int number) {
        data.push(number);
    }

    public void pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("No elements");
        }
        data.pop();
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }
}
