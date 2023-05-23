package org.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone(); // Hacer una copia del arreglo original
        ForkJoinPool pool = new ForkJoinPool();
        QuickSortTask task = new QuickSortTask(sortedArray, 0, sortedArray.length - 1);
        pool.invoke(task);
        pool.shutdown();
    }

    private static class QuickSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        public QuickSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start < end) {
                int pivotIndex = partition(array, start, end);
                QuickSortTask leftTask = new QuickSortTask(array, start, pivotIndex - 1);
                QuickSortTask rightTask = new QuickSortTask(array, pivotIndex + 1, end);
                invokeAll(leftTask, rightTask);
                leftTask.join();
                rightTask.join();
            }
        }

        private int partition(int[] array, int start, int end) {
            int pivot = array[end];
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (array[j] <= pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, end);
            return i + 1;
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
