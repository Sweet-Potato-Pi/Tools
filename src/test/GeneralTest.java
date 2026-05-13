package test;

import general.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * For testing any of the tools in this project.
 */
public class GeneralTest {
    public static void main(String[] args) {
        System.out.println("Start");
        ArrayList<Integer> list;
        list = new ArrayList<>(Arrays.asList(2,457,2,68,12,6,82,6,82,45,82,56,81,46,2,486,2));
        Sorting.quicksortInPlace(list, 0, list.size() - 1);
        System.out.println(list);
    }
    
}
