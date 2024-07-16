package ru.aston.sorting;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import static ru.aston.sorting.ArraySortingHelper.*;
import static ru.aston.sorting.SortOption.*;

public class GnomeSort implements SortingStrategy {

    @Override
    public SortingResult sort(Integer[] array, SortOption sortOption) {
        return switch (sortOption) {
            case ALL -> gnomeSortAll(array);
            case EVEN, ODD -> gnomeSortEvenOrOdd(array, sortOption.equals(EVEN));
        };
    }

    private SortingResult gnomeSortAll(Integer[] array) {
        LocalDateTime start = LocalDateTime.now();
        int countPermutation = 0;

        int length = array.length;

        if (length <= 1) {
            return getSortingResult(array, countPermutation, Duration.between(start, LocalDateTime.now()));
        }

        int currentIndex = 0;
        int referenceIndex = 1;
        while (currentIndex < length) {
            if (currentIndex == 0 || array[currentIndex].compareTo(array[currentIndex - 1]) >= 0) {
                currentIndex = referenceIndex;
                referenceIndex++;
            } else {
                swap(array, currentIndex, currentIndex - 1);
                countPermutation++;
                currentIndex--;
            }
        }

        LocalDateTime end = LocalDateTime.now();
        Duration timeSpent = Duration.between(start, end);

        return getSortingResult(array, countPermutation, timeSpent);
    }

    private SortingResult gnomeSortEvenOrOdd(Integer[] array, boolean even) {
        Integer[] currentArray = Arrays.stream(array)
                .filter(number -> {
                    if (even) {
                        return number % 2 == 0;
                    } else {
                        return number % 2 != 0;
                    }
                })
                .toArray(Integer[]::new);

        SortingResult sortingResult = this.gnomeSortAll(currentArray);
        Integer[] sortArr = sortingResult.getArray();

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (even) {
                if (array[i] % 2 == 0) {
                    array[i] = sortArr[index++];
                }
            } else {
                if (array[i] % 2 != 0) {
                    array[i] = sortArr[index++];
                }
            }
        }

        return new SortingResult(array, sortingResult.getCountPermutations(), sortingResult.getTimeSpent());
    }
}
