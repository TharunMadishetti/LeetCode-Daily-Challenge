class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        // int[][][] dp=new int[a.length+1][1+b.length][2];
        int[][] prev=new int[b.length+1][2];
        for(int i=a.length;i>=0;i--)
        {
            int[][] curr=new int[b.length+1][2];
            for(int j=b.length;j>=0;j--)
            {
                if(i==a.length || j==b.length)
                {
                    curr[j][0]=Integer.MIN_VALUE;
                    curr[j][1]=0;
                    continue;  
                } 
        int pick = a[i]*b[j];
                int c=0;
curr[j][0]=Math.max(pick+prev[j+1][1],Math.max(prev[j][c],curr[j+1][c]));
                c=1;
                curr[j][1]=Math.max(pick+prev[j+1][1],Math.max(prev[j][c],curr[j+1][c]));
            }
            prev=curr;
        }
        return prev[0][0];
    }
//     public int solve(int[] a,int[] b,int i,int j,int c,int[][][] dp)
//     {
//         if(i==a.length || j==b.length)
//             return c==0?Integer.MIN_VALUE:0;
//         if(dp[i][j][c]!=Integer.MIN_VALUE)
//             return dp[i][j][c];
//         int pick = a[i]*b[j];
//         return dp[i][j][c]=Math.max(pick+solve(a,b,i+1,j+1,1,dp),Math.max(solve(a,b,i+1,j,c,dp),solve(a,b,i,j+1,c,dp)));
        
//     }
}