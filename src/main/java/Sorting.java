public class Sorting {
    public SortingResult shakerSort(Integer[] array) {
        if (array.length <= 1) {
            return getSortingResult(array, 0);
        }

        int left = 0;
        int right = array.length - 1;
        int countPermutations = 0;
        int swapped;

        while (true) {
            swapped = 0;
            for (int i = 1; i < array.length; i++) {
                if (left == right) {
                    return getSortingResult(array, countPermutations);
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
                    return getSortingResult(array, countPermutations);
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

    private SortingResult getSortingResult(Integer[] array, int countPermutations) {
        return SortingResult.builder()
                .array(array)
                .countPermutations(countPermutations)
                .build();
    }
}
