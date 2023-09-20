//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp;
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        dp=new int[N][N];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        int ans=-1;
        for(int i=0;i<N;i++)
        ans=Math.max(solve(Matrix,0,i,N),ans);
        return ans;
    }
    public static int solve(int[][] m,int i,int j,int n)
    {
        if(j==n || j<0)return 0;
        if(i==n)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        return dp[i][j]=m[i][j]+Math.max(solve(m,i+1,j,n),Math.max(solve(m,i+1,j+1,n),solve(m,i+1,j-1,n)));
    }
}