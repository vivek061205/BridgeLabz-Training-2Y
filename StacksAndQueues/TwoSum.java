
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 10 (HashMap): Two Sum Problem
 * Given an array and a target sum, find two indices such that their values add up to the target.
 * Hint: Use a HashMap to store each element's index as you iterate.
 *       Check if (target - current_element) already exists in the map.
 * Time Complexity: O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Map: value -> index
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums   = {2, 7, 11, 15};
        int   target = 9;

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
            // Expected: [0, 1]  (nums[0] + nums[1] = 2 + 7 = 9)
        } else {
            System.out.println("No two-sum solution found.");
        }

        // Second test case
        int[] nums2   = {3, 2, 4};
        int   target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices: " + Arrays.toString(result2)); // Expected: [1, 2]
    }
}
