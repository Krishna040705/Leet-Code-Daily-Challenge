class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums1.length % 2 == 1) ans += IntStream.of(nums2).reduce(0, (a, b) -> a ^ b);
        if (nums2.length % 2 == 1) ans ^= IntStream.of(nums1).reduce(0, (a, b) -> a ^ b);
        return ans;
    }
}
