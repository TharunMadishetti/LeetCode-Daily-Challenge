//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair
    {
        int l,x;
        Pair(int l,int x)
        {
            this.l=l;
            this.x=x;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        
        Queue<Pair> q=new LinkedList<>();
        // Your code here
        q.add(new Pair(0,start));
        int[] dist=new int[(int)(1e5)];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        int  mod=(int)(1e5);
        while(!q.isEmpty())
        {
            int x=q.peek().x;
            int l=q.peek().l;
            q.poll();
            if(x==end)return l;
            for(int i:arr)
            {
                if(l+1<dist[(i*x)%mod])
                {
                    dist[(i*x)%mod]=l+1;
                    q.add(new Pair(l+1,(i*x)%mod));
                }
                
            }
        }
        return -1;
    }
}
