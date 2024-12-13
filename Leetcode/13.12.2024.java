public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0; // Use long to avoid overflow

        // Create a list of pairs (value, index)
        List<int[]> numWithIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numWithIndex.add(new int[]{nums[i], i});
        }

        // Sort the list by value first, then by index
        Collections.sort(numWithIndex, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Process each number in sorted order
        for (int[] pair : numWithIndex) {
            int index = pair[1];
            // If the current number is already marked, skip it
            if (marked[index]) {
                continue;
            }
            // Add the value to the score
            score += pair[0];
            // Mark the current element and its adjacent elements
            marked[index] = true; // Mark the current element
            if (index - 1 >= 0) {
                marked[index - 1] = true; // Mark left adjacent
            }
            if (index + 1 < n) {
                marked[index + 1] = true; // Mark right adjacent
            }
        }

        return score;
    }
}
