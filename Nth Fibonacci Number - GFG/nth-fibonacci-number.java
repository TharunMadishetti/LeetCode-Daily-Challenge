//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        int mod=(int)(1e9+7);
        if(n==1)
        return 1;
        if(n==2)
        return 1;
        int a=1,b=1;
        n-=2;
        while(n>0)
        {
            int t=(a+b)%mod;
            b=a;
            a=t;
            n--;
        }
        return a%mod;
        
    }
}