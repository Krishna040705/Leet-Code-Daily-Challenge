class Solution {
    public int largestCombination(int[] candidates) {
        int largestCombination = 0;
        
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            
            for (int num : candidates) {
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            
            largestCombination = Math.max(largestCombination, count);
        }
        
        return largestCombination;
    }
}
