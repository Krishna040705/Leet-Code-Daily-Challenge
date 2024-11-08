class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int count = (int) Math.pow(2, maximumBit) - 1;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
            int k = count ^ tmp;
            res[nums.length - i - 1] = k;
        }
        return res;
    }
}
