class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        for(int i=m-1;i>=0;i--)
        {
            int[] curr=new int[n];
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1)
                {
                    curr[j]=1;
                    continue;
                }
                if(i+1<m && j+1<n)
                    curr[j]=curr[j+1]+dp[j];
                else if(i+1<m)
                    curr[j]=dp[j];
                else
                    curr[j]=curr[j+1];
                // System.out.print(curr[j]+" ");
            }
           // System.out.println();

            dp=curr;
        }
        return dp[0];
    }
}