package org.example;

public class BubbleSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        int n = array.length;
        sortedArray = array.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    // Swap sortedArray[j] and sortedArray[j+1]
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
