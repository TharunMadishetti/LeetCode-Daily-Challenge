//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int d=0;
        for(int i:arr)
        {
            d=d+i;
        }
        if(d%2!=0)
        return 0;
        int k=d/2;
        int p[][]=new int[N+1][k+1];
        for(int i[]:p)
        {
            Arrays.fill(i,-1);
        }
        return solve(0,arr,k,p);
    }
    static int solve(int i,int[] a,int k,int[][] p)
    {
        if(i>=a.length)
        return 0;
        if(k==0)
        return 1;
        if(k<0)
        return 0;
        if(p[i][k]!=-1)
        return p[i][k];
        int in=solve(i+1,a,k-a[i],p);
        int ex=solve(i+1,a,k,p);
        return p[i][k]=in | ex;
    }
}