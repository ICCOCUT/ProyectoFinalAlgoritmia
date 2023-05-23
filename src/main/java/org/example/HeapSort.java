package org.example;

public class HeapSort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone(); // Hacer una copia del arreglo original

        int size = sortedArray.length;

        // Construir el heap (reorganizar el arreglo)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(sortedArray, size, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = size - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = sortedArray[0];
            sortedArray[0] = sortedArray[i];
            sortedArray[i] = temp;

            // Llamar a heapify en el subárbol reducido
            heapify(sortedArray, i, 0);
        }
    }

    private static void heapify(int[] array, int size, int rootIndex) {
        int largestIndex = rootIndex; // Inicializar el índice más grande como la raíz
        int leftChildIndex = 2 * rootIndex + 1; // Índice del hijo izquierdo
        int rightChildIndex = 2 * rootIndex + 2; // Índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (leftChildIndex < size && array[leftChildIndex] > array[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        // Si el hijo derecho es más grande que la raíz
        if (rightChildIndex < size && array[rightChildIndex] > array[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        // Si se encontró un elemento más grande que la raíz
        if (largestIndex != rootIndex) {
            // Intercambiar la raíz con el elemento más grande
            int temp = array[rootIndex];
            array[rootIndex] = array[largestIndex];
            array[largestIndex] = temp;

            // Recursivamente hacer heapify en el subárbol afectado
            heapify(array, size, largestIndex);
        }
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
