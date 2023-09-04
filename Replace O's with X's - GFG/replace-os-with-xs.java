//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
int[][] vis=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]=='O' && vis[i][0]==0)
            dfs(a,vis,i,0);
            if(a[i][m-1]=='O' && vis[i][m-1]==0)
            dfs(a,vis,i,m-1);
            
        }
        for(int i=0;i<m;i++)
        {
            if(a[0][i]=='O' && vis[0][i]==0)
            dfs(a,vis,0,i);
            if(a[n-1][i]=='O' && vis[n-1][i]==0)
            dfs(a,vis,n-1,i);
            
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O' && vis[i][j]==0)
                a[i][j]='X';
            }
        }
        return a;
    }
    static void dfs(char[][] c,int[][] vis,int i,int j)
    {
        int n = c.length,m=c[0].length;
        vis[i][j]=1;
        if(i+1<n && c[i+1][j]=='O' && vis[i+1][j]==0)
        dfs(c,vis,i+1,j);
        if(j+1<m && c[i][j+1]=='O' && vis[i][j+1]==0)
        dfs(c,vis,i,j+1);
        if(i-1>=0 && c[i-1][j]=='O' && vis[i-1][j]==0)
        dfs(c,vis,i-1,j);
        if(j-1>=0 && c[i][j-1]=='O' && vis[i][j-1]==0)
        dfs(c,vis,i,j-1);
    }
    }
