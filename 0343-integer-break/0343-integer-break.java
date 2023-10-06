class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int x,int[] dp)
    {
        if(x<=2)
            return x;
        if(dp[x]!=-1)
            return dp[x];
        int ans=x;
        for(int i=1;i<=x/2;i++)
        ans=Math.max(i*solve(x-i,dp),ans);
        return dp[x]=ans;
    }
}