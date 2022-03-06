package com.ifmo.task3.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

import static com.ifmo.task3.model.Person.Gender.MAN;

@EqualsAndHashCode
@ToString
public class Rocket {
    private String model;
    private Material material;
    @Getter
    private Person driver;
    @Getter
    private List<Person> passengers;

    public Rocket(
            @NonNull String model,
            @NonNull Material material
    ) {
        this.model = model;
        this.material = material;
    }

    public enum Material {
        TITAN,
        STEEL,
        PLUMBUM,
        SULFUR
    }

    public void setDriver(Person person) {
        if (person.getGender().equals(MAN) && person.getAge() > 18) {
            this.driver = person;
        } else {
            throw new NotAvailableException("Driver should be man and adult");
        }
    }

    public void setPassengers(List<Person> candidates) {
        List<Person> adultCandidates = candidates.stream().filter(c -> c.getAge() > 18).collect(Collectors.toList());
        this.passengers = adultCandidates;
    }
}
