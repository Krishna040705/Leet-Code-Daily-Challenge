class Solution {
public int[] finalPrices(int[] prices) {
int n = prices.length;
int arr[]= new int[n];
int flag=0;
for(int i=0;i<n;i++){
flag=0;
for(int j=i+1;j<n;j++){
if(prices[i]>=prices[j]){
arr[i]=prices[i]-prices[j];
flag=1;
break;
}
}
if(flag!=1)
arr[i]=prices[i];
}


    return arr;
}
}
