package com.ifmo.task3.model;

import org.junit.jupiter.api.Test;

import static com.ifmo.task3.model.Person.Gender.MAN;
import static com.ifmo.task3.model.Person.Gender.WOMAN;
import static org.junit.jupiter.api.Assertions.*;

class RocketTest extends DomainTest {

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