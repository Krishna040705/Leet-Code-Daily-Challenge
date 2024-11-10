class Solution {
    boolean check(int curr[],int target){
        int currVal = 0;
        for(int i = 0;i < curr.length;i++){
           currVal += curr[i] > 0 ? 1 << i : 0;
        }
        return currVal >= target;
    }
    void update(int curr[],int num,boolean add){
        for(int i = 0;i < Integer.SIZE;i++){
            if(add) curr[i] += (num >> i) & 1;
            else curr[i] -= (num >> i) & 1;
        }
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int curr[] = new int[Integer.SIZE];
        int ans = Integer.MAX_VALUE;
        for(int i = 0,j = 0;i <= j && j < nums.length;j++){
            update(curr,nums[j],true);
            for(;i <= j && check(curr,k);i++){
                ans = Math.min(ans,j - i + 1);
                update(curr,nums[i],false);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
