package ru.aston.sorting;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.aston.sorting.SortOption.*;

@RequiredArgsConstructor
public class ShakerSortingTest {
    private final SortingStrategy sortingStrategy = new ShakerSorting();

    @DisplayName("Проверка четной сортировки shaker на двух элементах")
    @Test
    public void shakerSortEvenArrayTwoElement() {
        Integer[] arrayTest = {4, 2};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{2, 4}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());

        Integer[] arrayTest2 = new Integer[]{1, 3};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2, EVEN);

        assertArrayEquals(arrayTest2, sortingResult2.getArray());
        assertEquals(0, sortingResult2.getCountPermutations());

        Integer[] arrayTest3 = new Integer[]{1, 2};
        SortingResult sortingResult3 = sortingStrategy.sort(arrayTest3, EVEN);

        assertArrayEquals(arrayTest3, sortingResult3.getArray());
        assertEquals(0, sortingResult3.getCountPermutations());

        Integer[] arrayTest4 = new Integer[]{2, 1};
        SortingResult sortingResult4 = sortingStrategy.sort(arrayTest4, EVEN);

        assertArrayEquals(arrayTest4, sortingResult4.getArray());
        assertEquals(0, sortingResult4.getCountPermutations());

        Integer[] arrayTest5 = new Integer[]{2, 2};
        SortingResult sortingResult5 = sortingStrategy.sort(arrayTest5, EVEN);

        assertArrayEquals(arrayTest5, sortingResult5.getArray());
        assertEquals(0, sortingResult5.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на трех элементах")
    @Test
    public void shakerSortEvenArrayThreeElement() {
        Integer[] arrayTest = {1, 2, 4};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());

        Integer[] arrayTest1 = {1, 4, 2};
        SortingResult sortingResult1 = sortingStrategy.sort(arrayTest1, EVEN);

        assertArrayEquals(new Integer[]{1, 2, 4}, sortingResult1.getArray());
        assertEquals(1, sortingResult1.getCountPermutations());

        Integer[] arrayTest2 = {4, 1, 2};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2, EVEN);

        assertArrayEquals(new Integer[]{2, 1, 4}, sortingResult2.getArray());
        assertEquals(1, sortingResult2.getCountPermutations());

        Integer[] arrayTest3 = {2, 1, 4};
        SortingResult sortingResult3 = sortingStrategy.sort(arrayTest3, EVEN);

        assertArrayEquals(arrayTest3, sortingResult3.getArray());
        assertEquals(0, sortingResult3.getCountPermutations());

        Integer[] arrayTest4 = new Integer[]{2, 4, 3};
        SortingResult sortingResult4 = sortingStrategy.sort(arrayTest4, EVEN);

        assertArrayEquals(arrayTest4, sortingResult4.getArray());
        assertEquals(0, sortingResult4.getCountPermutations());

        Integer[] arrayTest5 = new Integer[]{4, 2, 3};
        SortingResult sortingResult5 = sortingStrategy.sort(arrayTest5, EVEN);

        assertArrayEquals(new Integer[]{2, 4, 3}, sortingResult5.getArray());
        assertEquals(1, sortingResult5.getCountPermutations());

        Integer[] arrayTest6 = new Integer[]{4, 2, 4};
        SortingResult sortingResult6 = sortingStrategy.sort(arrayTest6, EVEN);

        assertArrayEquals(new Integer[]{2, 4, 4}, sortingResult6.getArray());
        assertEquals(1, sortingResult6.getCountPermutations());

        Integer[] arrayTest7 = new Integer[]{7, 9, 5};
        SortingResult sortingResult7 = sortingStrategy.sort(arrayTest7, EVEN);

        assertArrayEquals(arrayTest7, sortingResult7.getArray());
        assertEquals(0, sortingResult7.getCountPermutations());

        Integer[] arrayTest8 = new Integer[]{4, 1, 4};
        SortingResult sortingResult8 = sortingStrategy.sort(arrayTest8, EVEN);

        assertArrayEquals(arrayTest8, sortingResult8.getArray());
        assertEquals(0, sortingResult8.getCountPermutations());

        Integer[] arrayTest9 = new Integer[]{4, 4, 1};
        SortingResult sortingResult9 = sortingStrategy.sort(arrayTest9, EVEN);

        assertArrayEquals(arrayTest9, sortingResult9.getArray());
        assertEquals(0, sortingResult9.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на массиве №1")
    @Test
    public void shakerSort1() {
        Integer[] arrayTest = {10, 1, 3, 4, 9, 0, 5};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{0, 1, 3, 4, 9, 10, 5}, sortingResult.getArray());
        assertEquals(3, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на массиве №2")
    @Test
    public void shakerSort2() {
        Integer[] arrayTest = {5, 2, 8, 3, 7, 4, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{5, 2, 4, 3, 7, 8, 1}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на массиве №3")
    @Test
    public void shakerSort3() {
        Integer[] arrayTest = {7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{7, 2, 5, 4, 3, 6, 1}, sortingResult.getArray());
        assertEquals(3, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на массиве №4")
    @Test
    public void shakerSort4() {
        Integer[] arrayTest = {5, 2, 8, 3, 5, 2, 8};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{5, 2, 2, 3, 5, 8, 8}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка четной сортировки shaker на массиве №5")
    @Test
    public void shakerSort5() {
        Integer[] arrayTest = {-5, -2, 8, -3, -5, -6, -8};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, EVEN);

        assertArrayEquals(new Integer[]{-5, -8, -6, -3, -5, -2, 8}, sortingResult.getArray());
        assertEquals(5, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на двух элементах")
    @Test
    public void shakerSortOddArrayTwoElement() {
        Integer[] arrayTest = {3, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{1, 3}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());

        Integer[] arrayTest2 = new Integer[]{2, 4};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2, ODD);

        assertArrayEquals(arrayTest2, sortingResult2.getArray());
        assertEquals(0, sortingResult2.getCountPermutations());

        Integer[] arrayTest3 = new Integer[]{1, 2};
        SortingResult sortingResult3 = sortingStrategy.sort(arrayTest3, ODD);

        assertArrayEquals(arrayTest3, sortingResult3.getArray());
        assertEquals(0, sortingResult3.getCountPermutations());

        Integer[] arrayTest4 = new Integer[]{2, 1};
        SortingResult sortingResult4 = sortingStrategy.sort(arrayTest4, ODD);

        assertArrayEquals(arrayTest4, sortingResult4.getArray());
        assertEquals(0, sortingResult4.getCountPermutations());

        Integer[] arrayTest5 = new Integer[]{1, 1};
        SortingResult sortingResult5 = sortingStrategy.sort(arrayTest5, ODD);

        assertArrayEquals(arrayTest5, sortingResult5.getArray());
        assertEquals(0, sortingResult5.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на трех элементах")
    @Test
    public void shakerSortOddArrayThreeElement() {
        Integer[] arrayTest = {2, 1, 5};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());

        Integer[] arrayTest1 = {2, 5, 3};
        SortingResult sortingResult1 = sortingStrategy.sort(arrayTest1, ODD);

        assertArrayEquals(new Integer[]{2, 3, 5}, sortingResult1.getArray());
        assertEquals(1, sortingResult1.getCountPermutations());

        Integer[] arrayTest2 = {5, 2, 1};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2, ODD);

        assertArrayEquals(new Integer[]{1, 2, 5}, sortingResult2.getArray());
        assertEquals(1, sortingResult2.getCountPermutations());

        Integer[] arrayTest3 = {1, 2, 5};
        SortingResult sortingResult3 = sortingStrategy.sort(arrayTest3, ODD);

        assertArrayEquals(arrayTest3, sortingResult3.getArray());
        assertEquals(0, sortingResult3.getCountPermutations());

        Integer[] arrayTest4 = new Integer[]{1, 5, 2};
        SortingResult sortingResult4 = sortingStrategy.sort(arrayTest4, ODD);

        assertArrayEquals(arrayTest4, sortingResult4.getArray());
        assertEquals(0, sortingResult4.getCountPermutations());

        Integer[] arrayTest5 = new Integer[]{5, 1, 2};
        SortingResult sortingResult5 = sortingStrategy.sort(arrayTest5, ODD);

        assertArrayEquals(new Integer[]{1, 5, 2}, sortingResult5.getArray());
        assertEquals(1, sortingResult5.getCountPermutations());

        Integer[] arrayTest6 = new Integer[]{5, 1, 5};
        SortingResult sortingResult6 = sortingStrategy.sort(arrayTest6, ODD);

        assertArrayEquals(new Integer[]{1, 5, 5}, sortingResult6.getArray());
        assertEquals(1, sortingResult6.getCountPermutations());

        Integer[] arrayTest7 = new Integer[]{4, 6, 8};
        SortingResult sortingResult7 = sortingStrategy.sort(arrayTest7, ODD);

        assertArrayEquals(arrayTest7, sortingResult7.getArray());
        assertEquals(0, sortingResult7.getCountPermutations());

        Integer[] arrayTest8 = new Integer[]{5, 2, 5};
        SortingResult sortingResult8 = sortingStrategy.sort(arrayTest8, ODD);

        assertArrayEquals(arrayTest8, sortingResult8.getArray());
        assertEquals(0, sortingResult8.getCountPermutations());

        Integer[] arrayTest9 = new Integer[]{5, 5, 2};
        SortingResult sortingResult9 = sortingStrategy.sort(arrayTest9, ODD);

        assertArrayEquals(arrayTest9, sortingResult9.getArray());
        assertEquals(0, sortingResult9.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №1")
    @Test
    public void shakerSortOddArray1() {
        Integer[] arrayTest = {-5, -2, 8, -3, -5, -6, -8};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{-5, -2, 8, -5, -3, -6, -8}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №2")
    @Test
    public void shakerSortOddArray2() {
        Integer[] arrayTest = {2, 1, 0, 0, 7, 3, 4};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{2, 1, 0, 0, 3, 7, 4}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №3")
    @Test
    public void shakerSortOddArray3() {
        Integer[] arrayTest = {1, 3, 5, 7, 9, 11, 13};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{1, 3, 5, 7, 9, 11, 13}, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №4")
    @Test
    public void shakerSortOddArray4() {
        Integer[] arrayTest = {0, 2, 4, 6, 8, 10, 12};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{0, 2, 4, 6, 8, 10, 12}, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №5")
    @Test
    public void shakerSortOddArray5() {
        Integer[] arrayTest = {13, 11, 9, 7, 5, 3, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{1, 3, 5, 7, 9, 11, 13}, sortingResult.getArray());
        assertEquals(21, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №6")
    @Test
    public void shakerSortOddArray6() {
        Integer[] arrayTest = {9, 5, 8, 7, 6, 8, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{1, 5, 8, 7, 6, 8, 9}, sortingResult.getArray());
        assertEquals(5, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №7")
    @Test
    public void shakerSortOddArray7() {
        Integer[] arrayTest = {1, -1, 8, 7, 13, 8, 1, 5};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{-1, 1, 8, 1, 5, 8, 7, 13}, sortingResult.getArray());
        assertEquals(5, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка нечетной сортировки shaker на массиве №8")
    @Test
    public void shakerSortOddArray8() {
        Integer[] arrayTest = {2, 2, 7, 7, 5, 6, 1, 5};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ODD);

        assertArrayEquals(new Integer[]{2, 2, 1, 5, 5, 6, 7, 7}, sortingResult.getArray());
        assertEquals(7, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на пустом массиве")
    @Test
    public void shakerSortArrayEmpty() {
        Integer[] arrayTest = {};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на одном элементе")
    @Test
    public void shakerSortArrayOneElement() {
        Integer[] arrayTest = {1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на двух элементах")
    @Test
    public void shakerSortArrayTwoElement() {
        Integer[] arrayTest = {3, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(new Integer[]{1, 3}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());

        Integer[] arrayTest2 = new Integer[]{1, 3};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2, ALL);

        assertArrayEquals(arrayTest2, sortingResult2.getArray());
        assertEquals(0, sortingResult2.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на уже отсортированном массиве")
    @Test
    public void shakerSortArrayAlreadySortedAscending() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6, 7};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на отсортированном массиве по убыванию")
    @Test
    public void shakerSortArrayAlreadySortedDescending() {
        Integer[] arrayTest = {7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(21, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве, в котором есть одинаковые элементы")
    @Test
    public void shakerSortArrayWithRepeatingElements() {
        Integer[] arrayTest = {5, 3, 5, 1, 3, 8, 10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(new Integer[]{1, 3, 3, 5, 5, 8, 10}, sortingResult.getArray());
        assertEquals(6, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве со всеми одинаковыми элементами")
    @Test
    public void shakerSortArrayEqualsElement() {
        Integer[] arrayTest = {1, 1, 1, 1, 1, 1, 1, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве №1")
    @Test
    public void shakerSortArray1() {
        Integer[] arrayTest = {7, 1, 1, 4, 3, 8, 10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(new Integer[]{1, 1, 3, 4, 7, 8, 10}, sortingResult.getArray());
        assertEquals(5, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве №2")
    @Test
    public void shakerSortArray2() {
        Integer[] arrayTest = {4, 10, 7, 8, 0, 9, 2};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(new Integer[]{0, 2, 4, 7, 8, 9, 10}, sortingResult.getArray());
        assertEquals(12, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве №3")
    @Test
    public void shakerSortArray3() {
        Integer[] arrayTest = {1, -1, 7, 5, 0, -9, -10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest, ALL);

        assertArrayEquals(new Integer[]{-10, -9, -1, 0, 1, 5, 7}, sortingResult.getArray());
        assertEquals(16, sortingResult.getCountPermutations());
    }

    @DisplayName("Проверка общей сортировки shaker на массиве с большим количеством элементов")
    @Test
    public void shakerSortArray4() {
        Integer[] array = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        SortingResult sortingResult = sortingStrategy.sort(array, ALL);

        Integer[] arrayTest = Arrays.copyOf(array, 1000);
        Arrays.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
    }
}