package com.savya.utilities.sorting;

public class SelectionSort implements SortingStrategy {

    @Override
    public void sort(int[] arr, SortOrder order) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (order == SortOrder.ASCENDING) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                } else {
                    if (arr[j] > arr[minIndex]) {
                        minIndex = j;
                    }
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, SortOrder.ASCENDING);
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

}
