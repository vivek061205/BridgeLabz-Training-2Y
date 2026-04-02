
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 6 (HashMap): Find All Subarrays with Zero Sum
 * Given an array, find all subarrays whose elements sum to zero.
 * Hint: Use a HashMap to store cumulative sum -> list of indices.
 *       If the same cumulative sum appears again, a zero-sum subarray exists between those indices.
 */
public class SubarraysWithZeroSum {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        // Map: cumulative sum -> list of indices where this sum was seen
        Map<Integer, List<Integer>> sumIndexMap = new HashMap<>();
        sumIndexMap.computeIfAbsent(0, k -> new ArrayList<>()).add(-1); // base case

        int cumulativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (sumIndexMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumIndexMap.get(cumulativeSum)) {
                    result.add(new int[]{startIndex + 1, i}); // subarray [start..i]
                }
            }
            sumIndexMap.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays (start, end) indices:");
        for (int[] range : subarrays) {
            System.out.println("  [" + range[0] + ", " + range[1] + "]");
        }
    }
}
