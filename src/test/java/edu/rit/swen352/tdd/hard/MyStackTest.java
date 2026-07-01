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

    // isEmpty() TESTS
    @Test
    @DisplayName("isEmpty: returns true for an empty stack")
    void testIsEmptyTrue() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        assertTrue(stack.isEmpty());
    } 
    
    @Test
    @DisplayName("isEmpty: returns false for an non-empty stack")
    void testIsEmptyFalse() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);

        int pushedElement = 10;
        stack.push(pushedElement);
        assertFalse(stack.isEmpty());
    }  

    // size() TEST
    @Test
    @DisplayName("size: returns size 0 for a new empty stack")
    void testSizeZeroOnNewStack() {
        MyStack<Integer> stack = new MyStack<Integer>();
        
        int expected = 0;
        assertEquals(expected, stack.size());
    }  

    @Test
    @DisplayName("size: returns stack size after multiple pushes")
    void testSizeAfterMultiplePushes() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }  

    // push() TESTS
    @Test
    @DisplayName("push: adds an element to the stack")
    void testPushElementToStack() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);

        int pushedElement = 30;
        stack.push(pushedElement);
        assertEquals(1, stack.size());
    }  

    @Test
    @DisplayName("push: throws IllegalStateException when stack is full")
    void testPushThrowsExceptionWhenFull() {
        int givenCapacity = 2;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);
        stack.push(1);
        stack.push(2);
        assertThrows(IllegalStateException.class, () -> stack.push(3));
    }

    // pop() TESTS
    @Test
    @DisplayName("pop: removes and returns the top element of the stack")
    void testPopRemovesAndReturnsTopElement() {
        int givenCapacity = 5;
        MyStack<Integer> stack = new MyStack<Integer>(givenCapacity);

        int lastPushedElement = 5;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(lastPushedElement);

        int popResult = stack.pop();
        assertEquals(lastPushedElement, popResult);
    }  

    // peek() TESTS
}

