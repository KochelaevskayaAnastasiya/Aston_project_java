package ru.aston.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aston.exception.NotFoundException;
import ru.aston.sorting.*;

import java.util.HashMap;
import java.util.Map;

import static ru.aston.service.SortView.GNOME;
import static ru.aston.service.SortView.SHAKER;

@Service
@Slf4j
public class SortingServiceImpl implements SortingService {
    private static final Map<SortView, SortingStrategy> sortingMap = new HashMap<>();

    static {
        sortingMap.put(SHAKER, new ShakerSorting());
        sortingMap.put(GNOME, new GnomeSort());
    }

    @Override
    public SortingResult sort(Integer[] array, SortView view, SortOption option) {
        SortingStrategy sortingStrategy = sortingMap.get(view);
        if (sortingStrategy == null) {
            log.warn("Unknown sort type: {}", option);
            throw new NotFoundException("Unknown sort type: " + view);
        }

        SortingResult sortingResult = sortingStrategy.sort(array, option);
        log.info("Sorting result: number of permutations = {}, time spent in seconds = {}",
                sortingResult.getCountPermutations(), sortingResult.getTimeSpent().toMillis() / 1000.0);
        return sortingResult;
    }
}
