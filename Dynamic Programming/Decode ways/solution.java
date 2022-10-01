class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    public int solve(String s,int i)
    {
        if(i>=s.length())
            return 1;
        if(s.charAt(i)=='0')
            return 0;
        if(i==s.length()-1)
            return 1;
        if(dp[i]!=-1)
            return dp[i];
        int one=0,two=0;
        if(i+1<s.length() && s.charAt(i)!='0')
        one=solve(s,i+1);
        if(i+1<s.length() && ((s.charAt(i)=='2' && s.charAt(i+1)<='6') || s.charAt(i)=='1'))
            two=solve(s,i+2);
        dp[i]=one+two;
        return dp[i];   
    }
}
