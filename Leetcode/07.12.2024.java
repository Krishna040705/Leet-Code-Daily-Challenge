class Solution {
    public boolean isPossible(int[] nums,int maxOperations,int mid){
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(mid <= nums[i]){
                if(nums[i]%mid == 0)
                    count += nums[i]/mid - 1;
                else
                    count += nums[i]/mid;
            }
        }
        return count <= maxOperations; 
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = nums[0];
        for(int i = 0;i < nums.length;i++)
            high = Math.max(high,nums[i]);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(nums,maxOperations,mid)){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}
