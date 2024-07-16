package ru.aston.sorting;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Проверка общей сортировки gnome на пустом массиве")
    @Test
    public void gnomeSortAllArrayEmpty() {
        Integer[] arrayTest = {};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве с одним элементом")
    @Test
    public void gnomeSortAllArrayOneElement() {
        Integer[] arrayTest = {1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве с двумя элементами")
    @Test
    public void gnomeSortAllArrayTwoElement() {
        Integer[] arrayTest = {3, 1};
        Integer[] sortArray = reverseArr(arrayTest);
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(sortArray, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на отсортированном массиве")
    @Test
    public void gnomeSortAllArrayAlreadySortedAscending() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на отстортированном в обратном порядке массиве")
    @Test
    public void gnomeSortAllArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] sortArray = reverseArr(arrayTest);
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(sortArray, sortingResult.getArray());
        assertEquals(45, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве одинаковых элементов")
    @Test
    public void gnomeSortAllArrayEqualsElement() {
        Integer[] arrayTest = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве положительных элементов")
    @Test
    public void gnomeSortAllArrayPositive() {
        Integer[] arrayTest = {6, 0, 1, 4, 3, 8, 10, 10, 2, 0};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        Integer[] arrayReview = Arrays.copyOf(arrayTest, arrayTest.length);
        Arrays.sort(arrayReview);

        assertArrayEquals(arrayReview, sortingResult.getArray());
        assertEquals(19, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве отрицательных элементов")
    @Test
    public void gnomeSortAllArrayNegative() {
        Integer[] arrayTest = {-2, -3, -1, 0, -7, -5, 0, -9, -10, -2};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ALL);

        Integer[] arrayReview = Arrays.copyOf(arrayTest, arrayTest.length);
        Arrays.sort(arrayReview);

        assertArrayEquals(arrayReview, sortingResult.getArray());
        assertEquals(27, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки gnome на массиве случайных элементов")
    @Test
    public void gnomeSortAll() {
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

    @DisplayName("Проверка сортировки gnome для случая четных (по значению) элементов на отстортированном в обратном порядке массиве")
    @Test
    public void gnomeSortEvenArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.EVEN);

        assertArrayEquals(new Integer[]{2, 9, 4, 7, 6, 5, 8, 3, 10, 1}, sortingResult.getArray());
    }

    @DisplayName("Проверка сортировки gnome для случая четных (по значению) элементов на массиве положительных элементов")
    @Test
    public void gnomeSortEvenArrayPositive() {
        Integer[] arrayTest = {6, 0, 3, 4, 1, 8, 10, 10, 2, 0};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.EVEN);

        assertArrayEquals(new Integer[]{0, 0, 3, 2, 1, 4, 6, 8, 10, 10}, sortingResult.getArray());
    }

    @DisplayName("Проверка сортировки gnome для случая четных (по значению) элементов на массиве отрацательных элементов")
    @Test
    public void gnomeSortEvenArrayNegative() {
        Integer[] arrayTest = {-2, -3, -1, 0, -7, -5, 0, -9, -10, -2};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.EVEN);

        assertArrayEquals(new Integer[]{-10, -3, -1, -2, -7, -5, -2, -9, 0, 0}, sortingResult.getArray());
    }

    @DisplayName("Проверка сортировки gnome для случая нечетных элементов на отстортированном в обратном порядке массиве")
    @Test
    public void gnomeSortOddArrayAlreadySortedDescending() {
        Integer[] arrayTest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{10, 1, 8, 3, 6, 5, 4, 7, 2, 9}, sortingResult.getArray());
    }

    @DisplayName("Проверка сортировки gnome для случая нечетных (по значению) элементов на массиве положительных элементов")
    @Test
    public void gnomeSortOddArrayPositive() {
        Integer[] arrayTest = {6, 0, 3, 4, 1, 8, 10, 10, 2, 0};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{6, 0, 1, 4, 3, 8, 10, 10, 2, 0}, sortingResult.getArray());
    }

    @DisplayName("Проверка сортировки gnome для случая нечетных (по значению) элементов на массиве отрацательных элементов")
    @Test
    public void gnomeSortOddArrayNegative() {
        Integer[] arrayTest = {-2, -3, -1, 0, -7, -5, 0, -9, -10, -2};
        SortingResult sortingResult = sorting.sort(arrayTest, SortOption.ODD);

        assertArrayEquals(new Integer[]{-2, -9, -7, 0, -5, -3, 0, -1, -10, -2}, sortingResult.getArray());
    }
}