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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[][] dp=new int[arr.length][arr.length+1];
	    for(int[] d:dp)
	    Arrays.fill(d,-1);
	    solve(arr,0,-1,dp);
	    return dp[0][0];
	}  
	public int solve(int[] a,int i,int p,int[][] dp){
	    if(i==a.length)
	    return 0;
	    if(dp[i][p+1]!=-1)
	    return dp[i][p+1];
	    if(p==-1 || a[i]>a[p])
	    return dp[i][p+1]=Math.max(a[i]+solve(a,i+1,i,dp),solve(a,i+1,p,dp));
	    return dp[i][p+1]=solve(a,i+1,p,dp);
	}
}