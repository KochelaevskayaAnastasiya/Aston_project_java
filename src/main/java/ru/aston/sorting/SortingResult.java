package ru.aston.sorting;

import lombok.*;

import java.time.Duration;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SortingResult {
    private Integer[] array;
    private int countPermutations;
    private Duration timeSpent;
}
