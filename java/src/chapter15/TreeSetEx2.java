package chapter15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        NavigableSet<Integer> descendingSet = scores.descendingSet();
        for(int score : descendingSet)
            System.out.print(score +" ");
        System.out.println();

        NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
        for(int score : ascendingSet)
            System.out.print(score+" ");

    }
}