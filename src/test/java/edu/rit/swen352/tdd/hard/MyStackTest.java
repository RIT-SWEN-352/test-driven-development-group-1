package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyStack} component.
 */
class MyStackTest {
    @Test
    @DisplayName("Constructor: with provided capacity (ex: 3)")
    void constructorWithCapacity() {
        int givenCapacity = 3;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        assertEquals(givenCapacity, stack.getCapacity());
    }   
}
