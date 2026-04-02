

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 8 (HashMap): Longest Consecutive Sequence
 * Given an unsorted array, find the length of the longest consecutive elements sequence.
 * Hint: Use a HashSet to store all elements. For each element that is the start of a
 *       sequence (i.e., element-1 is NOT in the set), count consecutive elements forward.
 * Time Complexity: O(n)
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int longest = 0;

        for (int n : numSet) {
            // Only start counting at the beginning of a sequence
            if (!numSet.contains(n - 1)) {
                int current = n;
                int length  = 1;
                while (numSet.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Array: java.util.Arrays.toString(nums)");
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums));
        // Expected: 4  (sequence: 1, 2, 3, 4)
    }
}
