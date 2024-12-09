class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int cnt = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 0);
        for (int i = 0; i < nums.length - 1; i ++) {
            if ((nums[i] + nums[i + 1]) % 2 == 1) {
                cnt ++;
            }
            prefix.put(i + 1, cnt);
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i ++) {
            int f = queries[i][0];
            int t = queries[i][1];
            if (prefix.get(t) - prefix.get(f) == t - f) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }
}
