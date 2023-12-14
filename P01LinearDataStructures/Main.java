package P01LinearDataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(4,1,15,96,42,7,15));
        int[] counts = new int[101];
        for (int n : numbers){
            counts[n]++;
        }

        for (int number = 0; number <= 100; number++) {
            int count = counts[number];
            for (int i = 0; i < count; i++){
                System.out.println(number + " ");
            }
        }
    }
}
