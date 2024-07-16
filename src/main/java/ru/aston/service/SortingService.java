package ru.aston.service;

import ru.aston.sorting.SortOption;
import ru.aston.sorting.SortingResult;

public interface SortingService {
    SortingResult sort(Integer[] array, SortView view, SortOption sortOption);
}
