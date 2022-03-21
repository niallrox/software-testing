package com.ifmo.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BtreeTest {

    protected Btree first;
    private Btree second;


    @BeforeEach
    void setUp() {
        first = new Btree();
        second = new Btree();
    }

    @Test
    void testInsert() {
        first.insert(1);
        assertEquals(1, first.search(1).getKeys()[0]);
//        first.remove(1);
    }

    @Test
    void testRemove() {
        first.remove(1);
        assertThrows(NullPointerException.class, () -> first.search(1));
    }

    @Test
    public void testInsertRemoveAndSearch() {
        first.insert(1);
        assertEquals(first.search(1).getKeys()[0],1);
        first.insert(3);
        first.insert(7);
        first.insert(10);
        first.insert(11);
        first.insert(4);
        first.insert(5);
        first.insert(2);
        first.insert(12);
        first.insert(6);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(3);
        assertEquals("[1, 2, 4, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.insert(3);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.search(7);
        assertArrayEquals(new Integer[]{7}, first.getArrayList().toArray(new Integer[0]));
        first.search(11);
        assertArrayEquals(new int[]{7, 10, 11}, first.getArrayList().stream().mapToInt(i -> i).toArray());
        first.search(10);
        assertArrayEquals(new int[]{7, 10}, first.getArrayList().stream().mapToInt(i -> i).toArray());
    }

    @Test
    void testRemoveAndSearchWhenNodeEquals() {
        second.insert(1);
        second.insert(1);
        second.insert(1);
        second.insert(1);
        second.insert(1);
        assertEquals("[1, 1, 1, 1, 1]", second.traverse().toString());
        second.remove(1);
        assertEquals("[1, 1, 1, 1]", second.traverse().toString());
        second.search(1);
        assertArrayEquals(new int[]{1}, second.getArrayList().stream().mapToInt(i -> i).toArray());
    }
}