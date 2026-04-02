

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 3: Stock Span Problem
 * For each day in a stock price array, calculate the span — the number of
 * consecutive days (including today) for which the price was <= today's price.
 * Hint: Use a stack to keep track of indices of prices in descending order.
 */
public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        // Stack stores indices of days whose prices are in descending order
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop all days with price <= prices[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // If stack is empty, all previous prices were <= today
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span   = calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span:   " + Arrays.toString(span));
        // Expected: [1, 1, 1, 2, 1, 4, 6]
    }
}
