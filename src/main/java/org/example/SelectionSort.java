package org.example;

public class SelectionSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        int n = array.length;
        sortedArray = array.clone();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[i];
            sortedArray[i] = temp;
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
