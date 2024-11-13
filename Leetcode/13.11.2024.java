import java.util.*;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int ind1 = binarySearchLower(nums, i + 1, n, lower - nums[i]);
            int ind2 = binarySearchUpper(nums, i + 1, n, upper - nums[i]);
            ans += (ind2 - ind1);
        }
        
        return ans;
    }
    
    private int binarySearchLower(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int binarySearchUpper(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
