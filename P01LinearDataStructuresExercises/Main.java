package P01LinearDataStructuresExercises;

import P01LinearDataStructuresExercises.implementations.ReversedList;

public class Main {
    public static void main(String[] args) {

        ReversedList<Integer> rev = new ReversedList<>();
        rev.add(1);
        rev.add(2);
        rev.add(3);
        rev.add(4);
        rev.add(5);
        rev.add(6);
        rev.add(7);
        rev.add(8);
        rev.add(9);
        rev.add(10);

        System.out.println(rev.removeAt(9));
        System.out.println(rev.removeAt(0));
    }
}
