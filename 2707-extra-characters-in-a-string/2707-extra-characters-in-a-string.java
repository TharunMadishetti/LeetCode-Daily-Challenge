class Solution {
    public int minExtraChar(String s, String[] d) {
        int[] dp=new int[s.length()];
       
        for(int i=s.length()-1;i>=0;i--)
        {
            int mn=s.length();
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++)
            {
                sb.append(s.charAt(j));
                for(int k=0;k<d.length;k++)
                {
                    if(sb.toString().equals(d[k]))
                        mn=Math.min(mn,j+1<s.length()?dp[j+1]:0);
                }
        }
        mn=Math.min(mn,1+(i+1<s.length()?dp[i+1]:0));
         dp[i]=mn;
        }
        return dp[0];
    }
    public int solve(String s,int i,String[] d,int[] dp)
    {
        // System.out.println(i);
        if(i==s.length())
            return 0;
       if(dp[i]!=-1)
           return dp[i];
        int mn=s.length();
        StringBuilder sb=new StringBuilder();
        for(int j=i;j<s.length();j++)
        {
            sb.append(s.charAt(j));
            for(int k=0;k<d.length;k++)
            {
                if(sb.toString().equals(d[k]))
                    mn=Math.min(mn,solve(s,j+1,d,dp));
            }
        }
        mn=Math.min(mn,1+solve(s,i+1,d,dp));
        return dp[i]=mn;
    }
}