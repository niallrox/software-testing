package com.ifmo.task3;

import com.ifmo.task3.model.Imperial;
import com.ifmo.task3.model.NotAvailableException;
import com.ifmo.task3.model.Person;
import com.ifmo.task3.model.Rocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.ifmo.task3.model.Person.Gender.MAN;
import static com.ifmo.task3.model.Person.Gender.WOMAN;
import static com.ifmo.task3.model.Rocket.Material.TITAN;

public class DomainTest {

    private final int DEFAULT_PEOPLE_COUNT = 4;
    private final int DEFAULT_ADULT_COUNT = 2;

    private Imperial imperial;
    private Rocket rocket;

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

    @Test
    public void checkNotAvailableDriverOnRocket() {
        assertAll(
                () -> assertThrows(NotAvailableException.class,
                        () -> rocket.setDriver(
                                imperial.women().stream().findAny().orElse(Person.builder().gender(WOMAN).build())
                        )
                ),
                () -> assertThrows(NotAvailableException.class,
                        () -> rocket.setDriver(imperial.men().stream()
                                .filter(m -> m.getAge() < 18)
                                .findAny()
                                .orElse(Person.builder().age(17).build())
                        )
                )
        );
    }

    @Test
    public void checkAvailableDriverOnRocket() {
        Person alex = Person.builder()
                .name("Alex")
                .age(20)
                .gender(MAN)
                .build();
        assertAll(
                () -> assertDoesNotThrow(() -> rocket.setDriver(alex)),
                () -> assertEquals(alex, rocket.getDriver())
        );
    }

    @Test
    public void checkCorrectPassengersCount() {
        rocket.setPassengers(imperial.getPeople());
        assertEquals(DEFAULT_ADULT_COUNT, rocket.getPassengers().size());
    }
}
