package P05DataStructuresBinaryTreesHeapsBST.implementations;

import P05DataStructuresBinaryTreesHeapsBST.interfaces.AbstractQueue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>>  {
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }


    public int size() {
        return this.elements.size();
    }


    public boolean isEmpty() {
        return false;
    }


    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLess(getParentIndex(index), index)){
            Collections.swap(this.elements, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private boolean isLess(int firstIndex, int secondIndex) {
        return getAt(firstIndex).compareTo(getAt(secondIndex)) < 0;
    }

    private E getAt(int index){
        return this.elements.get(index);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }


    public E peek() {
        ensureNonEmpty();
        return getAt(0);
    }

    private void ensureNonEmpty() {
        if(this.size() == 0){
            throw new IllegalStateException("Illegal call to peek on empty heap");
        }
    }



    public E poll() {
        ensureNonEmpty();
        E returnedValue = getAt(0);
        Collections.swap(this.elements, 0, this.size()-1);
        this.elements.remove(this.size()-1);
        this.heapifyDown(0);
        return returnedValue;
    }

    private E getLeftChild(int index){
        return this.elements.get(this.getLeftChildIndex(index));
    }

    private E getRightChild(int index){
        return this.elements.get(this.getRightChildIndex(index));
    }

    private int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index){
        return 2 * index + 2;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < this.size() && isLess(index, getLeftChildIndex(index))){
            int child = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if(rightChildIndex < this.size() && isLess(child, rightChildIndex)){
                child = rightChildIndex;
            }

            Collections.swap(this.elements, child, index);
            index = child;
        }
    }

    @NotNull
    public Iterator<E> iterator() {
        return null;
    }
}