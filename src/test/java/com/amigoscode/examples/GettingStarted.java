package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        for (Person p:people) {
            List<Person> personList = new ArrayList<>(10);
            int count = 0;
                if (p.getAge()<= 18 && count <= 10){
                    personList.add(p);
                    count++;
                } else {
                    break;
                }
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> personList = people.stream().filter(person -> person.getAge() <= 18).limit(10).toList();
        assertTrue(personList.size() == 10);
        assertTrue(personList.get(0).getAge() <= 18);
    }
}
