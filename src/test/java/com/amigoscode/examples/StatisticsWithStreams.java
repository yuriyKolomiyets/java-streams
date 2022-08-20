package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        long count = cars.stream().count();
        assertTrue(count == 1000);
        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        String res = cars.stream().min((car1, car2) -> (int) (car1.getPrice() - car2.getPrice()))
                .orElseThrow(NoSuchElementException::new).toString();
        System.out.println(res);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        String res = cars.stream().max((car1, car2) -> (int) (car1.getPrice() - car2.getPrice()))
                .orElseThrow(NoSuchElementException::new).toString();
        System.out.println(res);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
    }

}