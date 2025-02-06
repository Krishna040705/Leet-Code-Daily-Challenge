import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (freq > 1) {
                ans += nCr(freq, 2) * 8; 
            }
        }

        return ans;
    }

    
    private int nCr(int n, int r) {
        if (n < r) return 0;
        return (n * (n - 1)) / 2;  
    }
}
