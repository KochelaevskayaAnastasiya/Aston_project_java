import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SortingResult {
    private Integer[] array;
    private int countPermutations;
}
