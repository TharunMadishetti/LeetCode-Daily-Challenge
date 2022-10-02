class Solution {
    int mod=(int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp= new int[n+1][target+1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        solve(n,target,k,dp);
        return dp[n][target]%mod;
    }
    public int solve(int i,int t,int k,int[][] dp)
    {
    
        if(i==0)
            return t==0?1:0;
        if(dp[i][t]!=-1)
            return dp[i][t]%mod;
        int ans=0;
        for(int j=1;j<=k;j++)
        {
            if(j>t)
                break;
            ans=ans%mod+solve(i-1,t-j,k,dp);
        }
        dp[i][t]=ans%mod;
        return dp[i][t];
        
    }
}
