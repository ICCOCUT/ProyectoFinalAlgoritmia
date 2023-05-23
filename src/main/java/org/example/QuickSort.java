package org.example;

public class QuickSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone(); // Hacer una copia del arreglo original
        quicksort(sortedArray, 0, sortedArray.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            // Obtener el índice de partición
            int pi = partition(array, low, high);

            // Ordenar recursivamente los elementos antes y después de la partición
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Intercambiar array[i] con array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiar array[i+1] con el pivote
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
