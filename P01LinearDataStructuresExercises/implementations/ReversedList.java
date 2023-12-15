package P01LinearDataStructuresExercises.implementations;

import P01LinearDataStructuresExercises.interfaces.RevList;

import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<E> implements RevList<E> {

    private int size;
    private Object[] elements;
    private final int INITIAL_CAPACITY = 2;

    public ReversedList() {
        this.size = 0;
        this.elements = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E element) {
        this.elements[size++] = element;
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public E get(int index) {
        ensureIndex(index);
        return getAt(size - index - 1);
    }

    @Override
    public E removeAt(int index) {
        ensureIndex(index);


        int indexToRemove = index;
        E element = getAt(indexToRemove);
        this.elements[indexToRemove] = null;

        for (int i = indexToRemove; i < this.size ; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.size--;

        if (size == elements.length / 2){
            this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
        }
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return getAt(index--);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    private void ensureIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bound for index: "
                    + (index));
        }
    }
}