package ru.aston.sorting;

import java.time.Duration;
import java.time.LocalDateTime;

import static ru.aston.sorting.ArraySortingHelper.swap;
import static ru.aston.sorting.SortOption.*;
import static ru.aston.sorting.ArraySortingHelper.getSortingResult;

public class ShakerSorting implements SortingStrategy {
    @Override
    public SortingResult sort(Integer[] array, SortOption sortOption) {
        LocalDateTime start = LocalDateTime.now();
        if (array.length <= 1) {
            return getSortingResult(array, 0, Duration.between(start, LocalDateTime.now()));
        }

        if (sortOption.equals(ALL)) {
            return shakerSortAll(array, start);
        }
        return shakerSortEvenOrOdd(array, start, sortOption == EVEN);
    }

    private SortingResult shakerSortAll(Integer[] array, LocalDateTime start) {
        int left = 0;
        int right = array.length - 1;
        int countPermutations = 0;

        do {
            boolean swapped = false;
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

        return getSortingResult(array, countPermutations, Duration.between(start, LocalDateTime.now()));
    }

    private SortingResult shakerSortEvenOrOdd(Integer[] array, LocalDateTime start, boolean even) {
        Integer left = 0;
        Integer right = array.length - 1;
        int countPermutations = 0;
        Integer first = null;
        Integer next;

        do {
            boolean swapped = false;
            for (int i = left; i <= right; i++) {
                if (even ? array[i] % 2 != 0 : array[i] % 2 == 0) {
                    continue;
                }
                if (first == null) {
                    first = i;
                } else {
                    next = i;

                    if (array[first] > array[next]) {
                        swap(array, first, next);
                        swapped = true;
                        countPermutations++;
                    }
                    first = next;
                }
            }
            right = first;
            first = null;

            if (swapped == false || right.equals(left)) {
                break;
            }

            swapped = false;
            for (int i = right; i >= left; i--) {
                if (even ? array[i] % 2 != 0 : array[i] % 2 == 0) {
                    continue;
                }

                if (first == null) {
                    first = i;
                } else {
                    next = i;

                    if (array[first] < array[next]) {
                        swap(array, first, next);
                        swapped = true;
                        countPermutations++;
                    }
                    first = next;
                }
            }
            left = first;
            first = null;

            if (swapped == false) {
                break;
            }
        } while (left < right);

        return getSortingResult(array, countPermutations, Duration.between(start, LocalDateTime.now()));
    }
}
