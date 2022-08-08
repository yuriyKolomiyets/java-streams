package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sortedList = people.stream().sorted().limit(10).toList();
        List<Person> sortedList2 = people.stream().sorted(Comparator.comparing(Person::getAge))
                .limit(10).toList();
        sortedList2.forEach(System.out::println);
        System.out.println("===");
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> personList = people.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Person::getAge)))
                .limit(10).toList();
        personList.forEach(System.out::println);
    }


    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> blue = cars.stream()
                .filter(car -> car.getColor().equals("Blue"))
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(10).peek(System.out::println).toList();

        assertThat(blue.get(0).getColor().equals("Blue"));
    }

}
