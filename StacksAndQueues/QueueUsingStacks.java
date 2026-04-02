

import java.util.Stack;

/**
 * Problem 1: Implement a Queue Using Stacks
 * Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
 * Hint: Use one stack for enqueue and another for dequeue. Transfer elements between stacks as needed.
 */
public class QueueUsingStacks {

    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> dequeueStack = new Stack<>();

    // Add element to queue
    public void enqueue(int val) {
        enqueueStack.push(val);
    }

    // Remove element from queue (FIFO)
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty (underflow)");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    // Peek front of queue
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Peek: "    + queue.peek());    // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
