import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SortingResult {
    private Integer[] array;
    private int count_permutations;
}
