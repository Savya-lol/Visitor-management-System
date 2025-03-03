package com.savya.utilities.sorting;

public interface SortingStrategy {
    String getName(); 
    void sort(int[] arr, SortOrder order);
    void sort(int[] arr);
}