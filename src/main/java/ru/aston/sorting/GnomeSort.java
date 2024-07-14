package ru.aston.sorting;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class GnomeSort implements SortingStrategy {

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


    @Override
    public SortingResult sort(Integer[] array, SortOption sortOption) {
        return switch (sortOption) {
            case ALL -> gnomeSortAll(array);
            case EVEN -> gnomeSortEven(array);
            case ODD -> gnomeSortOdd(array);
        };
    }

    public SortingResult gnomeSortAll(Integer[] array){
        LocalDateTime start = LocalDateTime.now();
        int countPermutation = 0;

        int length = array.length;

        if (length <= 1){
            return getSortingResult(array, countPermutation,
                    Duration.between(start.toLocalTime(), LocalDateTime.now().toLocalTime()));
        }

        int currentIndex = 0;
        int referenceIndex = 1;
        while(currentIndex < length){
            if(currentIndex == 0 || array[currentIndex].compareTo(array[currentIndex - 1]) >= 0){
                currentIndex = referenceIndex;
                referenceIndex++;
            }else{
                swap(array, currentIndex, currentIndex - 1);
                countPermutation++;
                currentIndex--;
            }
        }

        LocalDateTime end = LocalDateTime.now();
        Duration timeSpent = Duration.between(start.toLocalTime(), end.toLocalTime());

        return getSortingResult(array, countPermutation, timeSpent);
    }


    public SortingResult gnomeSortEven(Integer[] array) {
        Integer[] evenArr = Arrays.stream(array).filter(x -> x % 2 == 0).toArray(Integer[]::new);
        SortingResult sortingResult =  this.gnomeSortAll(evenArr);

        Integer[] sortEvenArr = sortingResult.getArray();
        int evenIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = sortEvenArr[evenIndex++];
            }
        }

        return new SortingResult(array, sortingResult.getCountPermutations(), sortingResult.getTimeSpent());
    }


    public SortingResult gnomeSortOdd(Integer[] array) {
        Integer[] oddArr = Arrays.stream(array).filter(x -> (x % 2) != 0).toArray(Integer[]::new);
        SortingResult sortingResult =  gnomeSortAll(oddArr);

        Integer[] sortOddArr = sortingResult.getArray();
        int evenIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = sortOddArr[evenIndex++];
            }
        }

        return new SortingResult(array, sortingResult.getCountPermutations(), sortingResult.getTimeSpent());
    }


}
