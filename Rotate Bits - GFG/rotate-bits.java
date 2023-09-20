//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        ArrayList<Integer> ans=new ArrayList<>();
        String str = Integer.toBinaryString(N);
        str = "00000000000000000" + str;
        int trimLength = str.length() - 16;
        str = str.substring(trimLength);
        
        D = D % 16;
        
        //Left Rotation
        String left1 = str.substring(0, D);
        String right1 = str.substring(D);
        
        ans.add(Integer.parseInt(right1 + left1, 2));
        
        //Right rotation
        String left2 = str.substring(0, str.length() - D);
        String right2 = str.substring(str.length() - D);
        
        ans.add(Integer.parseInt(right2 + left2, 2));
        
        return ans;
    }
    
}