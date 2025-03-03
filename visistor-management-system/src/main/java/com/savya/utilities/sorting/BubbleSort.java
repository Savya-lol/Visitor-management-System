package com.savya.utilities.sorting;

public class BubbleSort implements SortingStrategy {
    @Override
    public String getName() {
        return "Bubble Sort";
    }
    
    @Override
    public void sort(int[] arr, SortOrder order) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean shouldSwap = (order == SortOrder.ASCENDING) ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1];
                if (shouldSwap) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sort(int[] arr) {
     sort(arr,SortOrder.ASCENDING);
    }
}