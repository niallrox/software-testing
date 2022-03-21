package com.ifmo.task3.model;

import org.junit.jupiter.api.Test;

import static com.ifmo.task3.model.Person.Gender.MAN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImperialTest extends DomainTest {

    @Test
    public void checkAdults() {
        Person dan = Person.builder()
                .name("Dan")
                .age(20)
                .gender(MAN)
                .build();
        imperial.insertPeople(dan);
        assertEquals(DEFAULT_ADULT_COUNT + 1, imperial.adults().size());
    }
}
