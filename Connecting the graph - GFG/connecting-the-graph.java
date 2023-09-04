//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
     int[] p,sz;
     int findp(int u)
    {
        if(p[u]==u)
        return u;
        return p[u]=findp(p[u]);
    }
     void UnionBySize(int u,int v)
    {
        int ulpu=findp(u);
        int ulpv=findp(v);
        if(sz[ulpu]>sz[ulpv])
        {
            p[ulpv]=ulpu;
            sz[ulpu]+=sz[ulpv];
        }
        else
        {
            p[ulpu]=ulpv;
            sz[ulpv]+=sz[ulpu];
        }
    }
    public int Solve(int n, int[][] edges) {
        // Code here
         p=new int[n];
	    for(int i=0;i<n;i++)
	    p[i]=i;
	     sz=new int[n];
	    Arrays.fill(sz,1);
        int e=0;
        for(int i=0;i<edges.length;i++)
        {
            int pu=findp(edges[i][0]);
            int pv=findp(edges[i][1]);
            if(pu==pv)
                e++;
            else
            UnionBySize(pu,pv);
        }
        int comp=0;
        for(int i=0;i<n;i++)
        if(p[i]==i)
        comp++;
        if(comp-1>e)
        return -1;
        return comp-1;
    }
}