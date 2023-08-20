//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int lb=n;
        int l=0,r=n-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(arr[m]==x)
            {
                lb=Math.min(lb,m);
                r=m-1;
            }
            else if(arr[m]<x)
            l=m+1;
            else
            r=m-1;
        }
        int rb=-1;
        l=0;
        r=n-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(arr[m]==x)
            {
                rb=Math.max(rb,m);
                l=m+1;
            }
            else if(arr[m]<x)
            l=m+1;
            else
            r=m-1;
        }
        // System.out.println(lb+" "+rb);
        if(lb>rb)
        return 0;
        return rb-lb+1;
    }
}