import java.util.Arrays;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // Sort the quantities array
        Arrays.sort(quantities);
        
        // Initialize binary search bounds
        int low = 1, high = quantities[quantities.length - 1], ans = 0;

        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2; // Midpoint of current range
            int totSum = 0; // Total containers needed for current mid

            // Calculate total containers needed
            for (int i = 0; i < quantities.length; i++) {
                totSum += (int) Math.ceil((double) quantities[i] / (double) mid);
            }
            
            // Adjust search range based on total containers
            if (totSum <= n) {
                ans = mid; // Update answer
                high = mid - 1; // Search in the lower half
            } else {
                low = mid + 1; // Search in the upper half
            }
        }

        return ans; // Return the minimized maximum quantity
    }
}
