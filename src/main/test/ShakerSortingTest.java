import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.aston.sorting.SortingStrategy;
import ru.aston.sorting.ShakerSorting;
import ru.aston.sorting.SortingResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class ShakerSortingTest {
    private final SortingStrategy sortingStrategy = new ShakerSorting();

    @Test
    public void shakerSortArrayEmpty() {
        Integer[] arrayTest = {};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArrayOneElement() {
        Integer[] arrayTest = {1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArrayTwoElement() {
        Integer[] arrayTest = {3, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(new Integer[]{1, 3}, sortingResult.getArray());
        assertEquals(1, sortingResult.getCountPermutations());

        Integer[] arrayTest2 = new Integer[]{1, 3};
        SortingResult sortingResult2 = sortingStrategy.sort(arrayTest2);

        assertArrayEquals(arrayTest2, sortingResult2.getArray());
        assertEquals(0, sortingResult2.getCountPermutations());
    }

    @Test
    public void shakerSortArrayAlreadySortedAscending() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6, 7};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArrayAlreadySortedDescending() {
        Integer[] arrayTest = {7, 6, 5, 4, 3, 2, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(21, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArrayWithRepeatingElements() {
        Integer[] arrayTest = {5, 3, 5, 1, 3, 8, 10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(new Integer[]{1, 3, 3, 5, 5, 8, 10}, sortingResult.getArray());
        assertEquals(6, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArrayEqualsElement() {
        Integer[] arrayTest = {1, 1, 1, 1, 1, 1, 1, 1};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
        assertEquals(0, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArray1() {
        Integer[] arrayTest = {7, 1, 1, 4, 3, 8, 10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(new Integer[]{1, 1, 3, 4, 7, 8, 10}, sortingResult.getArray());
        assertEquals(5, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArray2() {
        Integer[] arrayTest = {4, 10, 7, 8, 0, 9, 2};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(new Integer[]{0, 2, 4, 7, 8, 9, 10}, sortingResult.getArray());
        assertEquals(12, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArray3() {
        Integer[] arrayTest = {1, -1, 7, 5, 0, -9, -10};
        SortingResult sortingResult = sortingStrategy.sort(arrayTest);

        assertArrayEquals(new Integer[]{-10, -9, -1, 0, 1, 5, 7}, sortingResult.getArray());
        assertEquals(16, sortingResult.getCountPermutations());
    }

    @Test
    public void shakerSortArray4() {
        Integer[] array = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        SortingResult sortingResult = sortingStrategy.sort(array);

        Integer[] arrayTest = Arrays.copyOf(array, 1000);
        Arrays.sort(arrayTest);

        assertArrayEquals(arrayTest, sortingResult.getArray());
    }
}