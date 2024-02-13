package data.structures;

import java.util.ArrayList;
import java.util.Optional;

public class Stack {
    private int capacity;
    private int currentSize;
    private int topPosition;
    private ArrayList<Integer> stackBuffer;

    Stack(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        this.topPosition = 0;
        this.stackBuffer = new ArrayList<>();
    }

    public void push(int newValue) throws RuntimeException {
       var newSize = this.currentSize + 1;
       if (newSize > capacity) {
           throw new RuntimeException();
        }
       else {
           this.stackBuffer.add(newValue);
           this.currentSize++;
           this.topPosition = this.currentSize - 1;
       }
    }

    public Optional<Integer> pop(){
        if (this.currentSize > 0){
            var poppedValue = this.stackBuffer.remove(this.topPosition);
            this.currentSize--;
            if(this.currentSize == 0){
                this.topPosition = 0;
            }
            else {
                this.topPosition--;
            }
            return Optional.of(poppedValue);
        }
        return Optional.empty();
    }

    public Optional<Integer> peek(){
        if (this.currentSize == 0){
            return Optional.empty();
        }
        else{
            return Optional.of(this.stackBuffer.get(this.topPosition));
        }
    }

    public int getTopPosition() {
        return topPosition;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getCapacity() {
        return capacity;
    }
}
