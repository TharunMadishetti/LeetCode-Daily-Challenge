//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int c[], int N, int sum) {
       long[][] dp=new long[c.length][sum+1]; 
       for(int i=0;i<c.length;i++)
       Arrays.fill(dp[i],-1);
        return counter (c,c.length-1,sum,dp);
    } 
    public long counter(int c[],int i,int t,long[][] dp)
    {
        if(i==0)
        return t%c[i]==0?1:0;
        
        if(dp[i][t]!=-1)
        return dp[i][t];
        if(t==0)
        return 1; 
        long ntake=counter(c,i-1,t,dp),take=0;
        if(c[i]<=t)
        take=counter(c,i,t-c[i],dp);
        dp[i][t]=take+ntake;
        return dp[i][t];
        
    }
}