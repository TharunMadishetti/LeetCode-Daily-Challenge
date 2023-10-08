class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int[][][] dp=new int[a.length+1][1+b.length][2];
        for(int[][] x:dp)
            for(int[] y:x)
                Arrays.fill(y,Integer.MIN_VALUE);
        for(int i=a.length;i>=0;i--)
        {
            for(int j=b.length;j>=0;j--)
            {
                if(i==a.length || j==b.length)
                {
                    dp[i][j][0]=Integer.MIN_VALUE;
                    dp[i][j][1]=0;
                    continue;  
                } 
        int pick = a[i]*b[j];
                int c=0;
dp[i][j][0]=Math.max(pick+dp[i+1][j+1][1],Math.max(dp[i+1][j][c],dp[i][j+1][c]));
                c=1;
                dp[i][j][1]=Math.max(pick+dp[i+1][j+1][1],Math.max(dp[i+1][j][c],dp[i][j+1][c]));
            }
        }
        return dp[0][0][0];
    }
    public int solve(int[] a,int[] b,int i,int j,int c,int[][][] dp)
    {
        if(i==a.length || j==b.length)
            return c==0?Integer.MIN_VALUE:0;
        if(dp[i][j][c]!=Integer.MIN_VALUE)
            return dp[i][j][c];
        int pick = a[i]*b[j];
        return dp[i][j][c]=Math.max(pick+solve(a,b,i+1,j+1,1,dp),Math.max(solve(a,b,i+1,j,c,dp),solve(a,b,i,j+1,c,dp)));
        
    }
}