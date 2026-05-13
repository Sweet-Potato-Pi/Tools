package general;

import java.util.ArrayList;

/**
 * This class includes a number of methods for sorting arrays and lists.
 *
 * @author Andrej Coleman
 * @since May 13, 2026
 */
public class Sorting {
    /**
     * This is an in-place sorting algorithm for QuickSort that sorts a given {@link ArrayList}. Additionally this
     * method allows for sorting only one specific section of the list which is delimited by the start and end
     * indices, a and b.
     * @param list The {@link ArrayList} to be sorted.
     * @param a the starting index of the section to be sorted.
     * @param b the end index of the section to be sorted.
     * @param <E> tne type of object stored within this {@link ArrayList}.
     */
    public static <E extends Comparable<E>> void quicksortInPlace(ArrayList<E> list, int a, int b) {
        if (a >= b) {
            return;
        }
        int left = a;
        int right = b - 1;
        E pivot = list.get(b);
        E temp;

        while (left <= right) {
            while (left <= right && list.get(left).compareTo(pivot) < 0) {
                left++;
            }

            while (left <= right && list.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);

                left++;
                right--;
            }
        }

        temp = list.get(left);
        list.set(left, list.get(b));
        list.set(b, temp);

        quicksortInPlace(list, a , left - 1);
        quicksortInPlace(list, left + 1, b);
    }
}
