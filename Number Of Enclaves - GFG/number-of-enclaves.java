//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] a) {
        int n = a.length,m=a[0].length;
        int[][] vis=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]==1 && vis[i][0]==0)
            dfs(a,vis,i,0);
            if(a[i][m-1]==1 && vis[i][m-1]==0)
            dfs(a,vis,i,m-1);
            
        }
        for(int i=0;i<m;i++)
        {
            if(a[0][i]==1 && vis[0][i]==0)
            dfs(a,vis,0,i);
            if(a[n-1][i]==1 && vis[n-1][i]==0)
            dfs(a,vis,n-1,i);
            
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==1 && vis[i][j]==0)
                c++;
                // System.out.print(vis[i][j]+" ");
            }
            // System.out.println();
        }
        return c;
    }
     void dfs(int[][] c,int[][] vis,int i,int j)
    {
        int n = c.length,m=c[0].length;
        vis[i][j]=1;
        if(i+1<n && c[i+1][j]==1 && vis[i+1][j]==0)
        dfs(c,vis,i+1,j);
        if(j+1<m && c[i][j+1]==1 && vis[i][j+1]==0)
        dfs(c,vis,i,j+1);
        if(i-1>=0 && c[i-1][j]==1 && vis[i-1][j]==0)
        dfs(c,vis,i-1,j);
        if(j-1>=0 && c[i][j-1]==1 && vis[i][j-1]==0)
        dfs(c,vis,i,j-1);
    }
}