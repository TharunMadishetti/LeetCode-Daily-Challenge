//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int x, int[][] e,int threshold)
      {
          int ans=Integer.MAX_VALUE,mn=ans;
          int mx=ans;
          int[][] m=new int[n][n];
          for(int i=0;i<x;i++)
          {
              m[e[i][0]][e[i][1]]=e[i][2];
              m[e[i][1]][e[i][0]]=e[i][2];
          }
          for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                    if(j!=i && m[i][j]==0)
                    m[i][j]=Integer.MAX_VALUE;
              }
          
          for(int k=0;k<n;k++)
          {
              for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                    {
                        if(m[i][k]!=mx && m[k][j]!=mx && m[i][k]+m[k][j]<m[i][j])
                            m[i][j]=m[i][k]+m[k][j];
                    }
              }
          }
          
          
          for(int i=0;i<n;i++)
          {
              int c=0;
              for(int j=0;j<n;j++)
             {
                 
                 if(i!=j && m[i][j]<=threshold)
                    c++;
             }
            //  System.out.println(c+" "+i);
            if(c<=mn)
            {
                mn=c;
                ans=i;
            }
          }
          return ans;
          //code here
          
      }
}
