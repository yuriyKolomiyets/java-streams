package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List <Car> carsLess20K = cars.stream().filter(car -> car.getPrice() < 20_000.00).toList();
        carsLess20K.stream().limit(5).forEach(System.out::println);
        assertEquals("Mercury", carsLess20K.get(1).getMake());
        assertEquals("Ford", carsLess20K.get(2).getMake());
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(x -> x <= 5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n <= 10)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < even.length-1; i++) {
            intList.add(even[i]);
        }
        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);

        assertTrue(allEven);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {1, 4, 6, 8, 10, 11};

        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < evenAndOneOdd.length-1; i++) {
            intList.add(evenAndOneOdd[i]);
        }
        assertTrue(intList.stream().anyMatch(i -> i % 2 == 1));

    }

}



