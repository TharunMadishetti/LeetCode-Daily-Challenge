//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair
    {
        int x,d;
        Pair(int x,int d)
        {
            this.x=x;
            this.d=d;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here'
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.d-y.d);
        
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        pq.add(new Pair(S,0));
        while(!pq.isEmpty())
        {
            int d=pq.peek().d;
            int n=pq.peek().x;
            pq.remove();
            for(ArrayList<Integer> edj:adj.get(n))
            {
                // System.out.println(edj+" "+n);
                if(d+edj.get(1)<dist[edj.get(0)])
                {
                    dist[edj.get(0)]=d+edj.get(1);
                    pq.add(new Pair(edj.get(0),dist[edj.get(0)]));
                }
            }
        }
        return dist;
    }
}

