package org.example;

public class InsertionSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        int n = array.length;
        sortedArray = array.clone();

        for (int i = 1; i < n; ++i) {
            int key = sortedArray[i];
            int j = i - 1;

            while (j >= 0 && sortedArray[j] > key) {
                sortedArray[j + 1] = sortedArray[j];
                j = j - 1;
            }
            sortedArray[j + 1] = key;
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
