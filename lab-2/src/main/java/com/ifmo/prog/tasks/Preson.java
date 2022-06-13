package com.ifmo.prog.tasks;

import java.util.*;
import java.util.stream.Stream;

public class Preson implements Comparable<Preson> {


    @Override
    public int compareTo(Preson person) {
        return 0;
    }



























    public static void main(String[] args) {

        Arrays.stream(Preson.class.getDeclaredMethods()).forEach(System.out::println);

        Map<Key, String> map = new HashMap<>();
        Key k1 = new Key(1), k2 = new Key(2), k3 = new Key(3);
        map.put(k1, "1");
        map.put(k2, "2");
        map.put(k3, "3");

        k2.setValue(4);

        System.out.println(map.get(k2));
        System.out.println(map.get(new Key(2)));
        System.out.println(map.get(new Key(4)));

        Map<String, Integer> ms = new HashMap<>();
        String s1 = new String("12");
        String s2 = new String("13");
        ms.put(s1, 12);
        ms.put(s2, 13);

        System.out.println(ms.get(s2));
        System.out.println(s2 == "13");
        System.out.println(ms.get("13"));
    }
}

class Key {
    private int value;

    public Key(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class RunEx<T> {
    private final T list;

    public RunEx(T list) {
        this.list = list;
    }

    public T getList() {
        return list;
    }
}

class TypeSafe {
    public void trying() {
//        Number[] numbers = new Integer[10];
//        numbers[0] = 9.7d;
//        List<Number> numbers1 = new ArrayList<Integer>();
//
//        List<Integer> integers = new ArrayList<>();
//        List list = integers;
//        List<Number> numbers2 = list;
//        numbers2.add(9.7d);
//
//        Integer integer = integers.get(0);
//
//        List<Number>[] list1 = new ArrayList<Number>[10];

    }
}

class CanPutOrGet {
    //leftSide
    List<? extends Number> numbers = new ArrayList<>();
    List<? super Number> numbers2 = new ArrayList<>();
    List<?> numbers3 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        List<Object> lo = new ArrayList<>();
        ArrayList<Object> alo = new ArrayList<>();
        List<Number> ln = new ArrayList<>();
        ArrayList<Number> aln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        ArrayList<Integer> ali = new ArrayList<>();
        List<Double> ld = new ArrayList<>();
        ArrayList<Double> ald = new ArrayList<>();

    }

    public static void t1(List<? extends Number> l) {
    }

    public static void t2(List<? super Number> l) {
    }

//    Collections.max();
//    BaseStream
}

class Helper<T> {


    public List<Integer> numbers() {
        return Arrays.asList(1, 2);
    }
}


class Streams {
    public static void main(String[] args) {
        Helper<?> helper = new Helper();
        for (Integer j: helper.numbers()) {

        }
        List<Integer> l = new ArrayList<>(Arrays.asList(3, 2));
        Stream<Integer> stream = l.stream();
        System.out.println("A");
        stream = stream.peek(System.out::println);
        System.out.println("B");
        l.add(1);
        stream = stream.sorted();
        System.out.println("C");
        stream.forEach(System.out::println);
        System.out.println("D");
        System.out.println(stream.count());
    }
}

class Main {
    public static void main(String[] args) {
        Stream.of(Preson.class.getDeclaredMethods())
                .forEach(System.out::println);

//        Helper helper = new Helper();
//        for (Integer n:
//             helper.numbers()) {
//
//        }

    }
}
