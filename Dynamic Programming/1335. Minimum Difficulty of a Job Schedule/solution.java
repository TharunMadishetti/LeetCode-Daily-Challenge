class Solution {
    public int minDifficulty(int[] j, int d) {
        if(j.length<d)
            return -1;
        int[][] dp=new int[j.length][d+1];
        for(int i=0;i<j.length;i++)
            dp[i][0]=Integer.MAX_VALUE;
        for(int i=j.length-1;i>=0;i--)
        {
            for(int k=1;k<=d;k++)
            {
                int rest=i+1<j.length?dp[i+1][k-1]:Integer.MAX_VALUE;
                int mn=j[i]+(rest!=Integer.MAX_VALUE?rest:Integer.MAX_VALUE);
                int premax=j[i];
                if(k==1)
                {
                    mn=premax;
                    for(int l=i;l<j.length;l++)
                        premax=Math.max(j[l],premax);
                    dp[i][k]=premax;
                    continue;
                }
                int possible_tasks=j.length-i-k; 
                for(int l=1;l<=possible_tasks;l++)
                {
                    if(i+l>=j.length)
                        break;
                    premax=Math.max(premax,j[i+l]);
                    int rest_of_days;
                    if(i+l+1<j.length)
                    rest_of_days=dp[i+l+1][k-1];
                    else 
                        rest_of_days=Integer.MAX_VALUE;
                    if(rest_of_days<Integer.MAX_VALUE)
                    mn=Math.min(mn,premax+rest_of_days);
                }
                
                dp[i][k]=mn;
            }
        }
            
        return dp[0][d];
    }
  //recursive approach
//     public int minSolve(int[] j,int i,int d,int[][] dp)
//     {
//         if(i==j.length && d==0)
//             return 0;
//         if(d==0)
//             return Integer.MAX_VALUE;
//         if(dp[i][d]!=-1)
//             return dp[i][d];
//         int rest=minSolve(j,i+1,d-1,dp);
//         int mn=j[i]+(rest!=Integer.MAX_VALUE?rest:Integer.MAX_VALUE);
//         int premax=j[i];
//         if(d==1)
//         {
//             mn=premax;
//             for(int k=i;k<j.length;k++)
//                 premax=Math.max(j[k],premax);
//             return premax;
//         }
//         int possible_tasks=j.length-i-d; //6-2-2=2 6-4-2=0 6-1-1=4
//         for(int k=1;k<=possible_tasks;k++)
//         {
//             if(i+k>=j.length)
//                 break;
//             premax=Math.max(premax,j[i+k]);
//             int rest_of_days=minSolve(j,i+k+1,d-1,dp);
//             if(rest_of_days<Integer.MAX_VALUE)
//             mn=Math.min(mn,premax+rest_of_days);
//         }
//         return dp[i][d]=mn;
//     }
}
