package ru.aston.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.aston.service.SortView;
import ru.aston.service.SortingService;
import ru.aston.sorting.SortOption;
import ru.aston.sorting.SortingResult;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sort")
@Slf4j
public class SortingController {
    private final SortingService sortingService;

    @GetMapping
    public SortingResult getSortingResult(@RequestParam @NotNull Integer[] array,
                                          @RequestParam(defaultValue = "SHAKER") SortView view,
                                          @RequestParam(defaultValue = "ALL") SortOption option) {
        log.info("GET /sort: array sort request; array length={}, sort view={}, sort option={}",
                array.length, view, option);
        return sortingService.sort(array, view, option);
    }
}
