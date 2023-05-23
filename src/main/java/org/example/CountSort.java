package org.example;

public class CountSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        int n = array.length;
        sortedArray = array.clone();

        int max = getMaxValue(sortedArray);

        int[] count = new int[max + 1];

        for (int i = 0; i < n; ++i) {
            count[sortedArray[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= max; ++i) {
            while (count[i] > 0) {
                sortedArray[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    private static int getMaxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
