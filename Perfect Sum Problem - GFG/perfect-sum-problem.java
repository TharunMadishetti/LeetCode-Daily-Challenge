//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int m = (int)(1e9+7);
	    int[][] dp;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp=new int[n][sum+1];
	    for(int[] d:dp)
	    Arrays.fill(d,-1);
	    solve(0,arr,sum);
	   // for(int i=n-1;i>=0;i--)
	   // {
	   //     for(int t=sum;t>=0;t--)
	   //     {
	   //         if(t==0)
	   //         dp[i][t]=1;
	   //         else
	   //         {
	   //             int p=0,np=0;
	   //             if(t-arr[i]>=0)
	   //              p = i+1<n?dp[i+1][t-arr[i]]%m:(t==0)?1:0;
	   //             np=i+1<n?dp[i+1][t]%m:(t==0)?1:0;
	   //             dp[i][t]=(p%m+np%m)%m;
	   //         }
	   //     }
	   // }
	    return dp[0][sum]%m;
	} 
	public int solve(int i,int[] arr,int t)
	{
	    
	    if(t==0 && i==arr.length)
	    return 1;
	    if(i==arr.length)
	    return 0;
	    if(dp[i][t]!=-1)
	    return dp[i][t];
	    int p=0;
	    if(t-arr[i]>=0)
	    p=solve(i+1,arr,t-arr[i]);
	    int np=solve(i+1,arr,t);
	    return dp[i][t]=(p%m+np%m)%m;
	}
}