

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 7 (HashMap): Check for a Pair with Given Sum in an Array
 * Given an array and a target sum, find if there exists a pair of elements
 * whose sum equals the target.
 * Hint: Store visited numbers in a HashMap and check if (target - current) exists.
 */
public class PairWithGivenSum {

    public static int[] findPair(int[] arr, int target) {
        // Map: value -> index
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (visited.containsKey(complement)) {
                return new int[]{visited.get(complement), i};
            }
            visited.put(arr[i], i);
        }
        return new int[]{}; // no pair found
    }

    public static void main(String[] args) {
        int[] arr    = {8, 7, 2, 5, 3, 1};
        int   target = 10;

        int[] pair = findPair(arr, target);
        if (pair.length == 2) {
            System.out.printf("Pair found at indices [%d, %d]: %d + %d = %d%n",
                    pair[0], pair[1], arr[pair[0]], arr[pair[1]], target);
        } else {
            System.out.println("No pair found with sum " + target);
        }
    }
}
