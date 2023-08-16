//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static int findCatalan(int n) {
        // code here
         int mod=(int)(1e9+7);
        int[][] dp=new int[n+1][n+1];
        for(int o=0;o<=n;o++)
        {
            for(int c=0;c<=n;c++)
            {
                if(o==0 && c==0)
                {
                    dp[0][0]=1;
                }
                else
                {
                    if(o>0 && c>=o)
                    dp[o][c]+=dp[o-1][c]%mod;
                    if(c>0)
                    dp[o][c]+=dp[o][c-1]%mod;
                }
            }
        }
        return dp[n][n];
    }
    
    // public static int solve(int o,int c,int[][] dp){
        
      
    //     if(dp[o][c]!=-1)
    //     return dp[o][c];
    //     int k=0;
    //     if(o>0 && c>=o)
    //     k+=solve(o-1,c,dp)%mod;
    //     if(c>0)
    //     k+=solve(o,c-1,dp)%mod;
    //     return dp[o][c]=k%mod;
    // }
    
        
}