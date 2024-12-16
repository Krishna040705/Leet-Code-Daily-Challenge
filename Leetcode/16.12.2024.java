class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[] { nums[i], i };
            q.add(arr);
        }
        for (int i = 0; i < k; i++) {
            int[] a = q.poll();
            a[0] = a[0] * multiplier;
            q.add(a);

        }
        while (!q.isEmpty()) {
            int[] aa = q.poll();
            nums[aa[1]] = aa[0];
        }
        return nums;
    }
} 
