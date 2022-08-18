package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS =
                people.stream()
                        .map(PersonDTO::map)
                        .toList();
        assertTrue(people.size() == personDTOS.size());

    }



    @Test
    void toSet() throws IOException {
        List<Car> cars = MockData.getCars();

        Set<String> carModels = cars.stream()
                .map(Car::getModel).limit(10)
                .collect(Collectors.toSet());

        System.out.println(carModels);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

