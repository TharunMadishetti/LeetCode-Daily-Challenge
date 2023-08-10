//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends




class Solution
{
     static int[][] dp;
    public static int longestCommonSubsequence(String text1, String text2) {
      dp=new int[text1.length()][text2.length()];
        for(int[] c: dp)
            Arrays.fill(c,-1);
        return Lcs(text1,text2,text1.length()-1,text2.length()-1);
    } 
    public static int Lcs(String s1, String s2,int i,int j){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
    if(s1.charAt(i)==s2.charAt(j))
       dp[i][j]= 1+ Lcs(s1,s2,i-1,j-1);
   else
      dp[i][j]= Math.max(Lcs(s1,s2,i-1,j),Lcs(s1,s2,i,j-1));
        return dp[i][j];
        }
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        return longestCommonSubsequence(s1,s2);
    }
    
}