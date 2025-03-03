package com.savya.utilities.sorting;

import java.util.*;

public class SortingRegistry {

    private static final Map<Integer, SortingStrategy> strategies = new LinkedHashMap<>();
    private static int nextId = 1;

    static {
        register(new BubbleSort());
        register(new SelectionSort());
    }

    public static void register(SortingStrategy strategy) {
        strategies.put(nextId++, strategy);
    }

    public static Collection<Map.Entry<Integer, SortingStrategy>> getStrategies() {
        return strategies.entrySet();
    }

    public static SortingStrategy getStrategy(int id) {
        if (id < 1 || id >= nextId) {
            System.err.println("Invalid choice. Using default strategy.");
            return strategies.get(1);
        }
        return strategies.get(id);
    }

    public static void printStrategies() {
        for (Map.Entry<Integer, SortingStrategy> entry : strategies.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }
}
