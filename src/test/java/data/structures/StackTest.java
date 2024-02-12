package data.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void push() {
        var stack = new Stack(10);
        stack.push(5);
        var peeked = stack.peek();
        assertTrue(peeked.isPresent());
        assertEquals(peeked.get(), 5);
        assertEquals(stack.getCurrentSize(), 1);
    }

    @Test
    void pushPastCapacity() {
        var stack = new Stack(0);
        Exception exception = assertThrows(RuntimeException.class,
                () -> {
                    stack.push(5);
                });
        assertEquals(RuntimeException.class, exception.getClass());
    }

    @Test
    void pop() {
        Stack stack = new Stack(10);

        // Add one element to the stack
        stack.push(5);
        var peeked = stack.peek();
        assertTrue(peeked.isPresent());
        assertEquals(peeked.get(), 5);
        assertEquals(stack.getCurrentSize(), 1);

        // Pop added element from the stack
        var popped = stack.pop();
        assertTrue(popped.isPresent());
        assertEquals(popped.get(), 5);
        assertEquals(stack.getCurrentSize(), 0);

        // Try to pop an element from the empty stack
        var poppedAgain = stack.pop();
        assertTrue(poppedAgain.isEmpty());
        assertEquals(stack.getCurrentSize(), 0);
    }

    @Test
    void peek() {
        Stack stack = new Stack(10);

        // Add one element to the stack
        stack.push(5);
        var peeked = stack.peek();
        assertTrue(peeked.isPresent());
        assertEquals(peeked.get(), 5);
        assertEquals(stack.getCurrentSize(), 1);
    }

    @Test
    void getCurrentSize() {
        Stack stack = new Stack(10);

        // Add one element to the stack
        stack.push(5);
        var peeked = stack.peek();
        assertTrue(peeked.isPresent());
        assertEquals(peeked.get(), 5);
        assertEquals(stack.getCurrentSize(), 1);
    }

    @Test
    void getCapacity() {
        Stack stack = new Stack(10);
        assertEquals(stack.getCapacity(), 10);
    }
}