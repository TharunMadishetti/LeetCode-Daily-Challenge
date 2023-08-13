class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp=new  int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    public boolean solve(int[] a,int i,int[] dp)
    {
        if(i==a.length)
            return true;
        if(dp[i]!=-1)
            return dp[i]==1;
        boolean l=false,r=false;
        if(i<a.length-1)
        {
            if(a[i]==a[i+1])
                l=solve(a,i+2,dp);
        }
        if(i<a.length-2)
        {
            if(a[i]==a[i+1] && a[i]==a[i+2])
                r=solve(a,i+3,dp);
            else if(a[i]+1==a[i+1] && a[i+1]+1==a[i+2])
                r=solve(a,i+3,dp);
        }
        dp[i]=l|r?1:0;
        return l|r;
        
    }
    
}