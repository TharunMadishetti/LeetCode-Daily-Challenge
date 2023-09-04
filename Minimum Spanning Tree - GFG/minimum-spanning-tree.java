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
    static class Pair
    {
        int x,c;
        Pair(int x,int c)
        {
            this.x=x;
            this.c=c;
        }
    }
	static int spanningTree(int V, int E, int e[][]){
	    // Code Here. 
	    ArrayList<ArrayList<ArrayList<Integer>>> g=new ArrayList<>();
	    for(int i=0;i<V;i++)
	    g.add(new ArrayList<>());
	    for(int i=0;i<E;i++)
	    {
	        ArrayList<Integer> l=new ArrayList<>();
	        l.add(e[i][1]);
	        l.add(e[i][2]);
	        g.get(e[i][0]).add(l);
	        l=new ArrayList<>();
	        l.add(e[i][0]);
	        l.add(e[i][2]);
	        g.get(e[i][1]).add(l);
	    }
	    PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.c-y.c);
	    int tc=0;
	    boolean[] vis=new boolean[V];
	    pq.add(new Pair(0,0));
	    while(!pq.isEmpty())
	    {
	        int u=pq.peek().x;
	        int c=pq.peek().c;
	        pq.remove();
	        if(vis[u])
	        continue;
	        vis[u]=true;
	        tc+=c;
	        for(ArrayList<Integer> edge:g.get(u))
	        {
	            if(!vis[edge.get(0)])
	            pq.add(new Pair(edge.get(0),edge.get(1)));
	        }
	    }
	    return tc;
	}
}