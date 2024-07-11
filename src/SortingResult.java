public class SortingResult {
    private final Integer[] array;
    private final Integer count_permutations;

    public SortingResult(SortingResultBuilder sortingResultBuilder){
        this.array = sortingResultBuilder.array;
        this.count_permutations = sortingResultBuilder.count_permutations;
    }

    public Integer getCount_permutations() {
        return count_permutations;
    }

    public Integer[] getArray() {
        return array;
    }

    public static class SortingResultBuilder{
        private Integer[] array;
        private Integer count_permutations;

        public SortingResultBuilder array(Integer[] array){
            this.array = array;
            return this;
        }
        public SortingResultBuilder count_permutations(Integer count_permutations){
            this.count_permutations = count_permutations;
            return this;
        }
        public SortingResult build(){
            return new SortingResult(this);
        }
    }
}
