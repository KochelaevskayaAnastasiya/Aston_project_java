package ru.aston.sorting;

import java.time.Duration;
import java.time.LocalDateTime;

public class ShakerSorting implements SortingStrategy {

    @Override
    public SortingResult sort(Integer[] array) {
        LocalDateTime start = LocalDateTime.now();

        if (array.length <= 1) {
            return getSortingResult(array, 0,
                    Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
        }

        int left = 0;
        int right = array.length - 1;
        int countPermutations = 0;
        boolean swapped;

        do {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                    countPermutations++;
                }
            }
            right--;

            if (swapped == false) {
                break;
            }

            swapped = false;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapped = true;
                    countPermutations++;
                }
            }
            left++;

            if (swapped == false) {
                break;
            }

        } while (left < right);

        return getSortingResult(array, countPermutations,
                Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
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
