class Solution {
    
    public int uniquePathsWithObstacles(int[][] g) {
        int[] dp;
        int a=g.length,b=g[0].length;
         if(a==1 && b==1) 
            return g[0][0]==1?0:1; 
        dp=new int[b]; 
        Arrays.fill(dp,0);
        for(int i=a-1;i>=0;i--){
            int[] dp2=dp;
            dp=new int[b];
            for(int j=b-1;j>=0;j--)
            {
                if(i==a-1 && j==b-1)
                    dp[j]=g[i][j]==1?0:1;
                else if(i==a-1)
                    dp[j]=g[i][j]==1?0:dp[j+1];
                else if(j==b-1)
                    dp[j]=g[i][j]==1?0:dp2[j];
                else
                    dp[j]=g[i][j]==1?0:dp2[j]+dp[j+1];
            }
            
        }
        return dp[0];
    }
}