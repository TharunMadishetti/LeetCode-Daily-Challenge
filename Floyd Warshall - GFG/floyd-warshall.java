//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] m)
    {
        // Code here 
        int[][] d=new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++)
        for(int j=0;j<m.length;j++)
        if(m[i][j]==-1)
            m[i][j]=Integer.MAX_VALUE;
        else if(i==j)
            m[i][j]=0;
        int mx=Integer.MAX_VALUE;
        for(int k=0;k<m.length;k++)
        {
            for(int i=0;i<m.length;i++)
            {
                for(int j=0;j<m.length;j++)
                {
                    
                    if(m[i][k]!=mx && m[k][j]!=mx && m[i][k]+m[k][j]<m[i][j])
                    m[i][j]=m[i][k]+m[k][j];
                }
            }
        }
        
        for(int i=0;i<m.length;i++)
        for(int j=0;j<m.length;j++)
        if(m[i][j]==Integer.MAX_VALUE)
            m[i][j]=-1;
        else if(i==j)
            m[i][j]=0;
        
        
    }
}