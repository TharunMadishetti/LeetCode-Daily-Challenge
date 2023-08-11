class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];  
        int[] prev=new int[amount+1];
        int[] cur=new int[amount+1];
        prev[0]=1;
        for(int i=1;i<=amount;i++)
        {
        if(i%coins[0]==0)
            prev[i]=1; 
         }
        cur[0]=1;
        for(int i=1;i<coins.length;i++)
            {
            
            for(int j=1;j<=amount;j++)
                {
                
        int ntake=prev[j],take=0;
        if(coins[i]<=j)
            take=cur[j-coins[i]];
        
        cur[j]=ntake+take; 
   
                }
            
            
            
            prev=cur;
            } 
        return prev[amount];
    /*    for(int[] h: dp)
            Arrays.fill(h,-1);
        return helper(amount,coins.length-1,coins,dp);
  
  */  
    } 
    public int helper(int t,int i,int[] c,int[][] dp) 
        { 
        if(dp[i][t]!=-1)
            return dp[i][t];
        if(i==0)
            return t%c[0]==0?1:0;
        
        if(t==0)
            return 1;
        int ntake=helper(t,i-1,c,dp),take=0;
        if(c[i]<=t)
            take=helper(t-c[i],i,c,dp);
        
        dp[i][t]=ntake+take; 
         return dp[i][t]; 
        
        }
}