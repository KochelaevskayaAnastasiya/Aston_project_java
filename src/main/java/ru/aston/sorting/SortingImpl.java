package ru.aston.sorting;

import java.time.Duration;
import java.time.LocalDateTime;

public class SortingImpl implements Sorting {

    @Override
    public SortingResult shakerSort(Integer[] array) {
        LocalDateTime start = LocalDateTime.now();

        if (array.length <= 1) {
            return getSortingResult(array, 0,
                    Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
        }

        int left = 0;
        int right = array.length - 1;
        int countPermutations = 0;
        int swapped;

        while (true) {
            swapped = 0;
            for (int i = 1; i < array.length; i++) {
                if (left == right) {
                    return getSortingResult(array, countPermutations,
                            Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
                }

                if (array[i] < array[i - 1]) {
                    swap(array, i - 1, i);
                    countPermutations++;
                    swapped++;
                } else {
                    if (swapped == 0) {
                        left = i;
                    }
                }
            }

            swapped = 0;
            for (int i = array.length - 2; i > 0; i--) {
                if (left == right) {
                    return getSortingResult(array, countPermutations,
                            Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
                }

                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    countPermutations++;
                    swapped++;
                } else {
                    if (swapped == 0) {
                        left = i;
                    }
                }
            }
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int copy = array[i];
        array[i] = array[j];
        array[j] = copy;
    }

    private SortingResult getSortingResult(Integer[] array, int countPermutations, Duration timeSpent) {
        return SortingResult.builder()
                .array(array)
                .countPermutations(countPermutations)
                .timeSpent(timeSpent)
                .build();
    }
}
