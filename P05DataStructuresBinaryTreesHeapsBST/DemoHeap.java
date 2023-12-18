package P05DataStructuresBinaryTreesHeapsBST;

import java.util.ArrayList;

public class DemoHeap {

    static class Heap<K extends Comparable<K>, V> {
        static class Element<K, V> {
            K key;
            V value;

            public Element(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }

        ArrayList<Element<K, V>> elements = new ArrayList<>();

        public int getSize() {
            return elements.size();
        }

        public boolean isEmpty() {
            return getSize() == 0;
        }

        public void insert(K key, V value) {
            Element<K, V> element = new Element<>(key, value);
            elements.add(element);

            swimUp(elements.size() - 1);
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < elements.size();

        }

        private void swimUp(int index) {
            if (!isValidIndex(index)){
                return;
            }
            if (index == 0){
                return;
            }

            int parentIndex = (index - 1) / 2;

            if (isLessThan(parentIndex,index)){
                swap(index,parentIndex);
                swimUp(parentIndex);
            }

        }

        private void swap(int indexA, int indexB) {
            Element<K,V> oldAValue = elements.get(indexA);
            elements.set(indexA,elements.get(indexB));
            elements.set(indexB,oldAValue);
        }

        private boolean isLessThan(int indexA, int indexB){
            return elements.get(indexA).getKey().compareTo(elements.get(indexB).getKey()) < 0;
        }


        public Element<K, V> removeMax() {
            Element<K, V> max = elements.get(0);
            elements.set(0, elements.get(elements.size() - 1));
            elements.remove(elements.size() - 1);
            sink(0);
            return max;
        }

        private void sink(int index) {
            int firstChildIndex = index * 2 + 1;
            int secondChildIndex = index * 2 + 2;

            if (!isValidIndex(firstChildIndex)){
                return;
            }

            int maxIndex;
            if (isValidIndex(secondChildIndex) && isLessThan(firstChildIndex,secondChildIndex)){
                maxIndex = secondChildIndex;
            }else {
                maxIndex = firstChildIndex;
            }

            if (isLessThan(index,maxIndex)){
                swap(index,maxIndex);
                sink(maxIndex);
            }
        }
    }

    public static void main(String[] args) {

        Heap<Integer, String> playersByScore = new Heap<>();
        playersByScore.insert(42, "Joro");
        playersByScore.insert(69, "RealPlayer");
        playersByScore.insert(13, "Unlucky");
        playersByScore.insert(3, "Some");
        playersByScore.insert(0, "Zero");
        playersByScore.insert(50, "cent");


        while (!playersByScore.isEmpty()) {
            Heap.Element<Integer, String> max = playersByScore.removeMax();
            System.out.println(max.getValue() + "->" + max.getKey());

        }
    }
}
