class Solution {
    public int getLastMoment(int n, int[] l, int[] r) {
        
        int ans=0;
        for(int x:l)
            ans=Math.max(ans,x);
        for(int x:r)
            ans=Math.max(ans,n-x);
        
        return ans;
    }
}