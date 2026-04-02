
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem 4: Sliding Window Maximum
 * Given an array and a window size k, find the maximum element in each
 * sliding window of size k.
 * Hint: Use a deque (double-ended queue) to maintain indices of useful
 *       elements in each window in decreasing order of their values.
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Deque stores indices; front always holds index of the current window's max
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove indices of elements smaller than nums[i] from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // Start recording results once the first full window is filled
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Array:  " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("Max per window: " + Arrays.toString(result));
        // Expected: [3, 3, 5, 5, 6, 7]
    }
}
