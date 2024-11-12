import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Create a map to keep track of the maximum beauty up to each price
        Map<Integer, Integer> maxBeautyMap = new HashMap<>();
        int maxBeautySoFar = 0;

        // Build the map with max beauty up to each price
        for (int[] item : items) {
            maxBeautySoFar = Math.max(maxBeautySoFar, item[1]);
            maxBeautyMap.put(item[0], maxBeautySoFar);
        }

        // Create an array of unique prices in ascending order for binary search
        int[] uniquePrices = maxBeautyMap.keySet().stream().sorted().mapToInt(i -> i).toArray();
        
        // Result array to store answers for each query
        int[] result = new int[queries.length];

        // Process each query to find the maximum beauty for each
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];

            // Binary search for the highest price less than or equal to the query
            int index = binarySearchMaxPrice(uniquePrices, query);

            // If no valid price is found, the answer is 0; otherwise, get the max beauty from the map
            result[i] = (index == -1) ? 0 : maxBeautyMap.get(uniquePrices[index]);
        }

        return result;
    }

    // Helper method to perform binary search and find the highest price <= query
    private int binarySearchMaxPrice(int[] prices, int query) {
        int left = 0, right = prices.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prices[mid] <= query) {
                result = mid;  // Keep track of the last valid index
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sol.maximumBeauty(items1, queries1))); // Output: [2, 4, 5, 5, 6, 6]

        int[][] items2 = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[] queries2 = {1};
        System.out.println(Arrays.toString(sol.maximumBeauty(items2, queries2))); // Output: [4]

        int[][] items3 = {{10, 1000}};
        int[] queries3 = {5};
        System.out.println(Arrays.toString(sol.maximumBeauty(items3, queries3))); // Output: [0]
    }
}
