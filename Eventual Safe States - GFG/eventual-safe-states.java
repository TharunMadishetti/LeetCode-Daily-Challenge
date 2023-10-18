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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    List<Integer> l;

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        l = new ArrayList<>();
        // Your code here
        
        boolean[] vis=new boolean[V];
        boolean[] pos=new boolean[V];
        boolean[] pvis= new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            dfs(vis,adj,i,pvis,pos);
        }
        for(int i=0;i<V;i++)
        {
            if(pos[i])
            l.add(i);
        }
        return l;
    }
    public void dfs(boolean[] vis,List<List<Integer>> adj,int i,boolean[] pvis,boolean[] pos)
    {
        vis[i]=true;
        pvis[i]=true;
        boolean f=true;
        if(adj.get(i).size()==0)
        {
            pos[i]=true;
            // l.add(i);
        }
        for(int neigh:adj.get(i))
        {
            if(!vis[neigh])
            dfs(vis,adj,neigh,pvis,pos);
            if(pvis[neigh])
            f=false;
            f=f&pos[neigh];
        }
        pos[i]=f;
        pvis[i]=false;
    }
}
