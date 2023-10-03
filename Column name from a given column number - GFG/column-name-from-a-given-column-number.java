//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
     String colName (long n)
    {
        // your code here
        StringBuilder res=new StringBuilder("");
        while(n>0){
            int c =(int)( --n % 26);
            res.append((char)(c+'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }
}