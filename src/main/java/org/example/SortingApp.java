package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class SortingApp extends JFrame {

    private JButton button100;
    private JButton button1000;
    private JButton button10000;
    private JButton button100000;
    private JTextArea originalArrayTextArea;
    private JTextArea sortedArrayTextArea;
    private JLabel labelTime;
    private JComboBox<String> algorithmComboBox;

    public SortingApp() {
        initializeUI();
        setListeners();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 650);
        setLayout(null);
        Font buttonFont = new Font("Montserrat", Font.BOLD, 14);

        Color buttonForeground = Color.black;
        Color buttonBackground = Color.white;

        button100 = new JButton("Sort 100");
        button100.setBounds(50, 30, 110, 30);
        button100.setFont(buttonFont);
        button100.setForeground(buttonForeground);
        button100.setBackground(buttonBackground);
        button100.setBorderPainted(true);
        add(button100);

        button1000 = new JButton("Sort 1000");
        button1000.setBounds(159, 30, 110, 30);
        button1000.setFont(buttonFont);
        button1000.setForeground(buttonForeground);
        button1000.setBackground(buttonBackground);
        button1000.setBorderPainted(true);
        add(button1000);

        button10000 = new JButton("Sort 10000");
        button10000.setBounds(270, 30, 110, 30);
        button10000.setFont(buttonFont);
        button10000.setForeground(buttonForeground);
        button10000.setBackground(buttonBackground);
        button10000.setBorderPainted(true);
        add(button10000);

        button100000 = new JButton("Sort 100000");
        button100000.setBounds(120, 80, 150, 30);
        button100000.setFont(buttonFont);
        button100000.setForeground(buttonForeground);
        button100000.setBackground(buttonBackground);
        button100000.setBorderPainted(true);
        add(button100000);

        originalArrayTextArea = new JTextArea();
        JScrollPane originalScrollPane = new JScrollPane(originalArrayTextArea);
        originalScrollPane.setBounds(50, 130, 320, 200);
        originalScrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#E8E8E8")));
        add(originalScrollPane);

        sortedArrayTextArea = new JTextArea();
        JScrollPane sortedScrollPane = new JScrollPane(sortedArrayTextArea);
        sortedScrollPane.setBounds(50, 350, 320, 200);
        sortedScrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#E8E8E8")));
        add(sortedScrollPane);

        labelTime = new JLabel("Tiempo de ejecucion: ");
        labelTime.setBounds(50, 570, 300, 30);
        add(labelTime);

        JLabel algorithmLabel = new JLabel("Algoritmo de Ordenamiento:");
        algorithmLabel.setBounds(50, 10, 160, 20);
        algorithmLabel.setBackground(buttonBackground);
        algorithmLabel.setForeground(Color.black);
        getContentPane().setBackground(Color.decode("#E8E8E8"));
        add(algorithmLabel);

        algorithmComboBox = new JComboBox<>();
        algorithmComboBox.addItem("Bubble Sort");
        algorithmComboBox.addItem("Selection Sort");
        algorithmComboBox.addItem("Insertion Sort");
        algorithmComboBox.addItem("Count Sort");
        algorithmComboBox.addItem("Merge Sort");
        algorithmComboBox.addItem("Heap Sort");
        algorithmComboBox.addItem("Quicksort"); // Agregado el algoritmo Quicksort al menú desplegable
        algorithmComboBox.addItem("QuicksortParallel");
        algorithmComboBox.addItem("MergeSortParallel");

        algorithmComboBox.setBounds(230, 10, 150, 20);
        algorithmComboBox.setBackground(Color.WHITE);
        algorithmComboBox.setForeground(Color.BLACK);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border emptyBorder = new EmptyBorder(1, 1, 1, 1);
        Border compoundBorder = new CompoundBorder(lineBorder, emptyBorder);
        algorithmComboBox.setBorder(compoundBorder);

        add(algorithmComboBox);

        setResizable(false);
        setVisible(true);
    }

    private void setListeners() {
        button100.addActionListener(e -> {
            int[] array = generateRandomArray(100);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button1000.addActionListener(e -> {
            int[] array = generateRandomArray(1000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button10000.addActionListener(e -> {
            int[] array = generateRandomArray(10000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button100000.addActionListener(e -> {
            int[] array = generateRandomArray(100000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    private void sortArray(int[] array) {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        switch (Objects.requireNonNull(selectedAlgorithm)) {
            case "Bubble Sort" -> BubbleSort.sort(array);
            case "Selection Sort" -> SelectionSort.sort(array);
            case "Insertion Sort" -> InsertionSort.sort(array);
            case "Count Sort" -> CountSort.sort(array);
            case "Merge Sort" -> MergeSort.sort(array);
            case "Heap Sort" -> HeapSort.sort(array);
            case "Quicksort" -> QuickSort.sort(array);
            case "QuicksortParallel" -> ParallelQuickSort.sort(array);
            case "MergeSortParallel" -> ParallelMergeSort.sort(array);
            //case "RadixSortParallel" -> ParallelRadixSort.sort(array);
            default -> BubbleSort.sort(array); // Default to Bubble Sort
        }
    }

    private void displayArrays(int[] array) {
        StringBuilder originalArrayString = new StringBuilder();
        StringBuilder sortedArrayString = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            originalArrayString.append(array[i]).append(" ");
            if ((i + 1) % 13 == 0) {
                originalArrayString.append("\n");
            }
        }

        int[] sortedArray = getSortedArray();
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArrayString.append(sortedArray[i]).append(" ");
            if ((i + 1) % 13 == 0) {
                sortedArrayString.append("\n");
            }
        }

        originalArrayTextArea.setText("Arreglo Original:\n" + originalArrayString);
        sortedArrayTextArea.setText("Arreglo ordenado:\n" + sortedArrayString);
    }

    private int[] getSortedArray() {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        assert selectedAlgorithm != null;
        return switch (selectedAlgorithm) {
            case "Bubble Sort" -> BubbleSort.getSortedArray();
            case "Selection Sort" -> SelectionSort.getSortedArray();
            case "Insertion Sort" -> InsertionSort.getSortedArray();
            case "Count Sort" -> CountSort.getSortedArray();
            case "Merge Sort" -> MergeSort.getSortedArray();
            case "Heap Sort" -> HeapSort.getSortedArray();
            case "Quicksort" -> QuickSort.getSortedArray();
            case "QuicksortParallel" -> ParallelQuickSort.getSortedArray();
            case "MergeSortParallel" -> ParallelMergeSort.getSortedArray();
            //case "RadixSortParallel" -> ParallelRadixSort.getSortedArray();
            default -> new int[0];
        };
    }

}
