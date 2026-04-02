

import java.util.Stack;

/**
 * Problem 2: Sort a Stack Using Recursion
 * Given a stack, sort its elements in ascending order using recursion.
 * Hint: Pop elements recursively, sort the remaining stack, and insert
 *       the popped element back at the correct position.
 */
public class SortStackRecursion {

    // Main sort method: recursively empties the stack, then inserts back in sorted order
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);           // sort the remaining stack
            insertSorted(stack, top);   // insert top at correct position
        }
    }

    // Insert val into its correct sorted position in an already-sorted stack
    private static void insertSorted(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
        } else {
            int top = stack.pop();
            insertSorted(stack, val);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Before sorting: " + stack);
        sortStack(stack);
        System.out.println("After sorting (top = max): " + stack);
    }
}
