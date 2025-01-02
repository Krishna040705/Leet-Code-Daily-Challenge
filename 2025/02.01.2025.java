class Solution {
    public boolean solve(String s){
         int n=s.length();
         char c1=s.charAt(0);
         char c2=s.charAt(n-1);
         if((c1=='a' || c1=='i' ||  c1=='o' || c1=='u' || c1=='e') && (c2=='a' || c2=='i' || c2=='o' || c2=='u' || c2=='e')){
               return true;
         }

         return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
     
        int n=queries.length;
        int m=words.length;
        int prefix[]=new int[m+1];
        int ans[]=new int[n];
        for(int i=0;i<m;i++){
            prefix[i+1]=solve(words[i])==true ? 1+prefix[i] : prefix[i];
        }
        
        int j=0;
        for(int q[]:queries){
             int s=q[0];
             int e=q[1];
             int cnt=prefix[e+1]-prefix[s];
             ans[j++]=cnt;
        }

        return ans;
    }
}
