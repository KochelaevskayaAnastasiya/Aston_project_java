package ru.aston.sorting;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class GnomeSortTest {
    private final SortingStrategy sorting = new GnomeSort();

    static Integer[] reverseArr(Integer[] array) {
        Integer[] newArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }

        return newArray;
    }

    @Test
    public void gnomeSortArrayEmpty() {
        Integer[] arrayTest = {};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayOneElement() {
        Integer[] arrayTest = {1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayTwoElement() {
        Integer[] arrayTest = {3, 1};
        Integer[] sortArray = reverseArr(arrayTest);
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(sortArray, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayAlreadySortedAscending() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] sortArray = reverseArr(arrayTest);
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(sortArray, sortingResult.getArray());
        assertEquals(45, sortingResult.getCountPermutations());
    }

    @Test
    public void evenGnomeSortArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.EVEN);

        assertArrayEquals(new Integer[]{2, 9, 4, 7, 6, 5, 8, 3, 10, 1}, sortingResult.getArray());
        assertEquals(10, sortingResult.getCountPermutations());
    }

    @Test
    public void oddGnomeSortArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{10, 1, 8, 3, 6, 5, 4, 7, 2, 9}, sortingResult.getArray());
        assertEquals(10, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayEqualsElement() {
        Integer[] arrayTest = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void gnomeSortArrayPositive() {
        Integer[] arrayTest = {6, 0, 1, 4, 3, 8, 10, 10, 2, 0};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        Integer[] arrayReview = Arrays.copyOf(arrayTest, arrayTest.length);
        Arrays.sort(arrayReview);

        assertArrayEquals(arrayReview, sortingResult.getArray());
        assertEquals(19, sortingResult.getCountPermutations());
    }

    @Test
    public void oddGnomeSortArrayPositive() {
        Integer[] arrayTest = {6, 0, 3, 4, 1, 8, 10, 10, 2, 0};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{6, 0, 1, 4, 3, 8, 10, 10, 2, 0}, sortingResult.getArray());
    }

    @Test
    public void gnomeSortArrayNegative() {
        Integer[] arrayTest = {-2, -3, -1, 0, -7, -5, 0, -9, -10, -2};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        Integer[] arrayReview = Arrays.copyOf(arrayTest, arrayTest.length);
        Arrays.sort(arrayReview);

        assertArrayEquals(arrayReview, sortingResult.getArray());
        assertEquals(27, sortingResult.getCountPermutations());
    }

    @Test
    public void oddGnomeSortArrayNegative() {
        Integer[] arrayTest = {-2, -3, -1, 0, -7, -5, 0, -9, -10, -2};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{-2, -9, -7, 0, -5, -3, 0, -1, -10, -2}, sortingResult.getArray());
    }

    @Test
    public void gnomeSortArray4() {
        Random rand = new Random();
        Integer[] array = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            array[i] = rand.nextInt(2001) - 1000;
        }

        SortingResult sortingResult = sorting.sort(array, SortOption.ALL);

        Integer[] arrayTest = Arrays.copyOf(array, 1000);
        Arrays.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
    }
}