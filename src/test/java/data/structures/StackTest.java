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
        var stack = new Stack(1);
        stack.push(5);
        assertEquals(stack.getCapacity(), stack.getCurrentSize());

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
        assertEquals(stack.getTopPosition(), 0);

        // Add second element to the stack
        stack.push(6);
        var peekedAgain = stack.peek();
        assertTrue(peekedAgain.isPresent());
        assertEquals(peekedAgain.get(), 6);
        assertEquals(stack.getCurrentSize(), 2);
        assertEquals(stack.getTopPosition(), 1);

        // Pop second added element from the stack
        var popped = stack.pop();
        assertTrue(popped.isPresent());
        assertEquals(popped.get(), 6);
        assertEquals(stack.getCurrentSize(), 1);
        assertEquals(stack.getTopPosition(), 0);

        // Pop first added element from the stack
        var poppedAgain = stack.pop();
        assertTrue(poppedAgain.isPresent());
        assertEquals(poppedAgain.get(), 5);
        assertEquals(stack.getCurrentSize(), 0);
        assertEquals(stack.getTopPosition(), 0);

        // Try to pop an element from the empty stack
        var poppedAgainAgain = stack.pop();
        assertTrue(poppedAgainAgain.isEmpty());
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