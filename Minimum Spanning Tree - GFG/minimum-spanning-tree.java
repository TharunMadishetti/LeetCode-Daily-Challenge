//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int[] p,sz;
    static int findp(int u)
    {
        if(p[u]==u)
        return u;
        return p[u]=findp(p[u]);
    }
    static void UnionBySize(int u,int v)
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
	static int spanningTree(int V, int E, int e[][]){
	    // Code Here. 
	    p=new int[V];
	    for(int i=0;i<V;i++)
	    p[i]=i;
	     sz=new int[V];
	    Arrays.fill(sz,1);
	    Arrays.sort(e,(ea,eb)->ea[2]-eb[2]);
	    int tc=0;
	    for(int i=0;i<E;i++)
	    {
	        int u = e[i][0];
	        int v = e[i][1];
	        int d = e[i][2];
	        if(findp(u)!=findp(v))
	        {
	            tc+=d;
	            UnionBySize(u,v);
	        }
	    }
	    return tc;
	}
}