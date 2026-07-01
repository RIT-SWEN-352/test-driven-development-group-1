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

    @Test
    @DisplayName("Constructor: with negative capacity, checks if exception is thrown")
    void testConstructorNegativeCapacity() {
        int negativeCapacity = -10;
        assertThrows(IllegalArgumentException.class, () -> new MyStack<Integer>(negativeCapacity));
    } 

    // getCapacity() TEST
    @Test
    @DisplayName("getCapacity: returns the fixed capacity of the stack")
    void testGetCapacity() {
        int givenCapacity = 41;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        assertEquals(41, stack.getCapacity());
    }  

    // isEmpty() TEST
    @Test
    @DisplayName("isEmpty: returns true for an empty stack")
    void testIsEmptyTrue() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        assertTrue(stack.isEmpty());
    }  

    // size() TEST

    // push() TESTS

    // pop() TESTS

    // peek() TESTS
}

