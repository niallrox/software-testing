package com.ifmo.task3.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.ifmo.task3.model.Person.Gender.MAN;

public class Imperial {
    @Getter
    private final String name;
    private final List<Person> people;

    public Imperial(
            @NonNull String name,
            List<Person> people
    ){
        this.name = name;
        this.people = new ArrayList<>(people);
    }

    public void insertPeople(Person person) {
        if (Objects.nonNull(person)) {
            people.add(person);
        }
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public int population() {
       return people.size();
    }

    public List<Person> men() {
        return people.stream().filter(Objects::nonNull).filter(mensPredicate()).collect(Collectors.toList());
    }

    public List<Person> women() {
        return people.stream().filter(Objects::nonNull).filter(mensPredicate().negate()).collect(Collectors.toList());
    }

    public List<Person> adults() {
        return people.stream().filter(Objects::nonNull).filter(p -> p.getAge() > 18).collect(Collectors.toList());
    }

    private Predicate<Person> mensPredicate() {
        return p -> p.getGender().equals(MAN);
    }
}