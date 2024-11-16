class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length + 1 -k];
        Arrays.fill(result, -1);
        boolean isValid = true;
        int i = 0;
        int count = 1;
        while (i < nums.length -1) {
            if (nums[i + 1] - nums[i] == 1) {
                count++;
            } else {
                count = 1;
            }
            if (count >= k) {
                result[i - k + 2] = nums[i + 1];
            }
            i++;
        }
        return result;
    }
}
