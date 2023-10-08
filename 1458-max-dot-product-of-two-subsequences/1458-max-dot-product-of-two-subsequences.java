class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][][] dp=new int[nums1.length][nums2.length][2];
        for(int[][] x:dp)
            for(int[] y:x)
                Arrays.fill(y,Integer.MIN_VALUE);
//         for(int i=a.length-1;i>=0;i--)
//         {
//             for(int j=b.length-1;j>=0;j--)
//             {
                
//             }
//         }
        return solve(nums1,nums2,0,0,0,dp);
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