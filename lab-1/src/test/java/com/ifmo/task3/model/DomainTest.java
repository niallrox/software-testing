package com.ifmo.task3.model;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static com.ifmo.task3.model.Person.Gender.MAN;
import static com.ifmo.task3.model.Person.Gender.WOMAN;
import static com.ifmo.task3.model.Rocket.Material.TITAN;

public class DomainTest {

    private final int DEFAULT_PEOPLE_COUNT = 4;
    protected final int DEFAULT_ADULT_COUNT = 2;

    protected Imperial imperial;
    protected Rocket rocket;

    @BeforeEach
    public void init() {
        Person womanNotAdult = Person.builder()
                .name("Alice")
                .age(12)
                .gender(WOMAN)
                .build();
        Person womanAdult = Person.builder()
                .name("Mary")
                .age(19)
                .gender(WOMAN)
                .build();
        Person manNotAdult = Person.builder()
                .name("Denis")
                .age(12)
                .gender(MAN)
                .build();
        Person manAdult = Person.builder()
                .name("Mark")
                .age(19)
                .gender(MAN)
                .build();
        imperial = new Imperial("Third Reich", List.of(manAdult, manNotAdult, womanAdult, womanNotAdult));

        rocket = new Rocket("SU-3434", TITAN);
    }
}
