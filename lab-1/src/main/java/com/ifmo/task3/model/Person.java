package com.ifmo.task3.model;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Person {
    private int age;
    private Gender gender;
    private String name;

    public enum Gender {
        MAN,
        WOMAN
    }
}
