package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer minValue = numbers.stream().min(Comparator.naturalOrder()).get();
        assertEquals(1, (int) minValue);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer maxValue = numbers.stream().max(Comparator.naturalOrder()).get();
        assertEquals(100, (int) maxValue);
    }
}
