package org.example;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone(); // Hacer una copia del arreglo original
        ForkJoinPool pool = new ForkJoinPool();
        ParallelMergeSortTask task = new ParallelMergeSortTask(sortedArray, 0, sortedArray.length - 1);
        pool.invoke(task);
        pool.shutdown();
    }

    private static class ParallelMergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        public ParallelMergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start < end) {
                int middle = (start + end) / 2;
                ParallelMergeSortTask leftTask = new ParallelMergeSortTask(array, start, middle);
                ParallelMergeSortTask rightTask = new ParallelMergeSortTask(array, middle + 1, end);
                invokeAll(leftTask, rightTask);
                leftTask.join();
                rightTask.join();
                merge(start, middle, end);
            }
        }

        private void merge(int low, int middle, int high) {
            int[] tempArray = Arrays.copyOfRange(array, low, high + 1);
            int left = 0;
            int right = middle - low + 1;
            int index = low;

            while (left <= middle - low && right <= high - low) {
                if (tempArray[left] <= tempArray[right]) {
                    array[index] = tempArray[left];
                    left++;
                } else {
                    array[index] = tempArray[right];
                    right++;
                }
                index++;
            }

            while (left <= middle - low) {
                array[index] = tempArray[left];
                left++;
                index++;
            }

            while (right <= high - low) {
                array[index] = tempArray[right];
                right++;
                index++;
            }
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
