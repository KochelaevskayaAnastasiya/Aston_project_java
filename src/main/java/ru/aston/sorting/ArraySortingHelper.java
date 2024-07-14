package ru.aston.sorting;

import java.time.Duration;

public class ArraySortingHelper {
    private ArraySortingHelper() {
    }

    public static void swap(Integer[] array, int i, int j) {
        int copy = array[i];
        array[i] = array[j];
        array[j] = copy;
    }

    public static SortingResult getSortingResult(Integer[] array, int countPermutations, Duration timeSpent) {
        return SortingResult.builder()
                .array(array)
                .countPermutations(countPermutations)
                .timeSpent(timeSpent)
                .build();
    }
}
