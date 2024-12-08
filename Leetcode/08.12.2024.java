class Solution {
    public int maxTwoEvents(int[][] events) {
        int no_events=events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);

        int[] suffixMax=new int[no_events];
        suffixMax[no_events-1]=events[no_events-1][2];

        for(int i=no_events-2;i>=0;i--)
        {
            suffixMax[i]=Math.max(suffixMax[i+1],events[i][2]);
        }
        int maxSum=0;
        for(int i=0;i<no_events;i++)
        {
            int left=i+1,right=no_events-1;
            int nextEventIndex=-1;

            while(left<=right)
            {
                int mid=left+(right-left)/2;
                if(events[mid][0]>events[i][1])
                {
                    nextEventIndex=mid;
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            if(nextEventIndex!=-1)
            {
                maxSum=Math.max(maxSum,events[i][2]+suffixMax[nextEventIndex]);
            }
            maxSum=Math.max(maxSum,events[i][2]);
        }
        return maxSum;
    }
}
