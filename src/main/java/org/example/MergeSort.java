package org.example;

public class MergeSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone();
        mergeSort(0, sortedArray.length - 1);
    }

    private static void mergeSort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {
        int[] tempArray = new int[high - low + 1];
        int left = low;
        int right = middle + 1;
        int index = 0;

        while (left <= middle && right <= high) {
            if (sortedArray[left] <= sortedArray[right]) {
                tempArray[index] = sortedArray[left];
                left++;
            } else {
                tempArray[index] = sortedArray[right];
                right++;
            }
            index++;
        }

        while (left <= middle) {
            tempArray[index] = sortedArray[left];
            left++;
            index++;
        }

        while (right <= high) {
            tempArray[index] = sortedArray[right];
            right++;
            index++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            sortedArray[low + i] = tempArray[i];
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
