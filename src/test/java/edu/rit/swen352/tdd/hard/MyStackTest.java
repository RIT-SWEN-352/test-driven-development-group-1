package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyStack} component.
 */
class MyStackTest {

    // ctor TESTS
    @Test
    @DisplayName("Constructor: with provided capacity (ex: 3)")
    void testConstructorWithCapacity() {
        int givenCapacity = 3;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        assertEquals(givenCapacity, stack.getCapacity());
    }   

    @Test
    @DisplayName("Constructor: without provided capacity (defaults to 20)")
    void tesConstructorWithoutCapacity() {
        MyStack<Integer> stack = new MyStack<Integer>();
        assertEquals(20, stack.getCapacity());
    }  

    // getCapacity() TEST

    // isEmpty() TEST

    // size() TEST

    // push() TESTS

    // pop() TESTS

    // peek() TESTS
}

