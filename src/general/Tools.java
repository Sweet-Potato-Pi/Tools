
package general;

import java.util.ArrayList;

/**
 * This class provides a bunch of general purpose tools for Java. Currently, the majority of these tools relate to
 * arrays and sorting, but I plan to add more in the future.
 * @author Andrej
 * @since Mar 29, 2024
 */
public class Tools {

    /**
     * Passes through entire array once and moves each element to a random index.
     *
     * @param arr An array of {@link Object}s to be shuffled.
     */
    public static void shuffle(Object[] arr) {
        Object current;
        int rand;
        for (int i = 0; i < arr.length; i++) {
            rand = (int) (Math.random() * arr.length);
            current = arr[i];
            arr[i] = arr[rand];
            arr[rand] = current;
        }

    }

    /**
     * Passes through entire array once and moves each element to a random index.
     *
     * @param arr An array of ints to be shuffled.
     */
    public static void shuffle(int[] arr) {
        int current;
        int rand;
        for (int i = 0; i < arr.length; i++) {
            rand = (int) (Math.random() * arr.length);
            current = arr[i];
            arr[i] = arr[rand];
            arr[rand] = current;
        }
    }

    /**
     * Passes through entire array once and moves each element to a random index.
     *
     * @param arr An array of doubles to be shuffled.
     */
    public static void shuffle(double[] arr) {
        double current;
        int rand;
        for (int i = 0; i < arr.length; i++) {
            rand = (int) (Math.random() * arr.length);
            current = arr[i];
            arr[i] = arr[rand];
            arr[rand] = current;
        }
    }

    /**
     * Swaps the elements of an array "arr" at the indexes index1 and index2
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(String[] arr, int index1, int index2) {
        String val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }

    /**
     * Swaps the elements of an array "arr" at the indexes index1 and index2
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        int val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }

    /**
     * Swaps the elements of an array "arr" at the indexes index1 and index2
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(double[] arr, int index1, int index2) {
        double val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }

    /**
     * Swaps the elements of an ArrayList "list" at the indexes index1 and index2
     *
     * @param list
     * @param index1
     * @param index2
     */
    public static void swap(ArrayList list, int index1, int index2) {
        Object val = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, val);
    }

    public static void insert(int[] arr, int val, int index) {

    }

    /**
     * Moves the selected integer in an array to a new position.
     * @param arr The target array
     * @param index The current index of the selected integer
     * @param newIndex The new index to move the selected integer to.
     */
    public static void moveTo(int[] arr, int index, int newIndex) {
        int value = arr[index];
        if (index < newIndex) {
            for (int i = index; i < newIndex; i++) {
                arr[i] = arr[i + 1];
            }
        } else if (index > newIndex) {
            for (int i = index; i > newIndex; i--) {
                arr[i] = arr[i - 1];
            }
        } else {
            return;
        }
        arr[newIndex] = value;
    }

    /**
     * Returns an array of pseudorandom integers in a given range.
     * @param amount The size of the array to be generated
     * @param min The minimum value of any element in the array
     * @param max The maximum value of any element in the array
     * @return An array of pseudorandom integers in the range from min to max.
     */
    public static int[] randomInts(int amount, int min, int max) {
        int[] out = new int[amount];
        for (int i = 0; i < amount; i++) {
            out[i] = (int) (Math.random() * (max - min)) + min;
        }
        return out;
    }

    /**
     * A binary search algorithm. Can only be used on sorted algorithms. Will return <i>an</i> index of the target
     * number, not necessarily the first or the last.
     *
     * @param in
     *         the array of integers to be searched
     * @param find
     *         the integer to be found
     * @return an integer representing an index of the integer <i>find</i>
     */
    public static boolean binarySearch(int[] in, int find) {
        if (in.length <= 1) {
            if (in.length == 1) {
                return in[0] == find;
            } else {
                return false;
            }
        }
        if (in[in.length / 2] > find) {
            return binarySearch(subarray(in, 0, in.length / 2), find);
        } else if (in[in.length / 2] < find) {
            return binarySearch(subarray(in, in.length / 2, in.length), find);
        } else {
            return true;
        }
    }

    /**
     * Checks an array of integers to see if it is sorted in rising order.
     * @param arr The array to be examined
     * @return True if sorted, false otherwise
     */
    public static boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("PROBLEM:: " + i);
                return false;
            }

        }

        return true;
    }

    /**
     * Merges two sorted arrays of integers into one sorted array
     *
     * @param a An array of integers
     * @param b Another array of integers
     * @return A single sorted array
     */
    public static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;

        while (indexA + indexB < merged.length && indexA < a.length && indexB < b.length) {

            if (a[indexA] < b[indexB]) {
                merged[indexA + indexB] = a[indexA];
                indexA++;

            } else {
                merged[indexA + indexB] = b[indexB];
                indexB++;

            }

        }

        if (indexA < a.length) {
            for (int i = indexA + indexB; i < merged.length; i++) {
                merged[i] = a[i - indexB];

            }
        } else if (indexB < b.length) {
            for (int i = indexA + indexB; i < merged.length; i++) {
                merged[i] = b[i - indexA];

            }
        }
        return merged;
    }

    /**
     * Derives a smaller array from the array of Objects <i>arr</i> based on start and end indexes. Useful for sorting
     * algorithms and really any time you are working with arrays.
     *
     * @param arr
     *         The array of Objects to be subdivided
     * @param start
     *         The start index of the new subarray
     * @param end
     *         The end index of the new subarray
     * @return An array of ints of length <i>start</i> - <i>end</i>.
     */
    public static Object[] subarray(Object[] arr, int start, int end) {
        Object[] out = new Object[end - start];
        for (int i = start; i < end; i++) {
            out[i - start] = arr[i];
        }
        return out;
    }

    /**
     * Derives a smaller array from the array of ints <i>arr</i> based on start and end indexes. Useful for sorting
     * algorithms and really any time you are working with arrays.
     *
     * @param arr
     *         The array of ints to be subdivided
     * @param start
     *         The start index of the new subarray
     * @param end
     *         The end index of the new subarray
     * @return An array of ints of length <i>start</i> - <i>end</i>.
     */
    public static int[] subarray(int[] arr, int start, int end) {
        int[] out = new int[end - start];
        for (int i = start; i < end; i++) {
            out[i - start] = arr[i];
        }
        return out;
    }

    /**
     * A recursive Merge Sort algorithm that sorts an array of ints by splitting it up into multiple subarrays and then
     * combining said arrays.
     *
     * @param arr The array of ints to be sorted
     * @return A sorted array of ints
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] left = subarray(arr, 0, arr.length / 2);
        int[] right = subarray(arr, arr.length / 2, arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j != 0 && arr[j - 1] > arr[i]) {

                } else {
                    moveTo(arr, i, j);
                    break;
                }
            }

        }
    }

    public static void bubbleSort(int[] arr) {
        boolean swapping = true;
        while (swapping) {
            swapping = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i, i + 1);
                    swapping = true;
                }
            }
        }
    }

    public static int[][] pascalsTriangle(int depth) {
        int[][] triangle = new int[depth][];
        triangle[0] = new int[1];
        triangle[0][0] = 1;
        for (int r = 1; r < depth; r++) {
            triangle[r] = new int[r + 1];
            triangle[r][0] = 1;
            for (int c = 1; c < triangle[r].length; c++) {
                if (c < triangle[r].length - 1) {
                    triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
                } else {
                    triangle[r][c] = 1;
                }
            }
        }
        return triangle;
    }
}