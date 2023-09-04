//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
     class Pair
    {
        int x,y,d;
        Pair(int x,int y,int d)
        {
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    int MinimumEffort(int g[][]) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.d-y.d);
         int[] dx=new int[]{0,0,-1,1};
         int[] dy=new int[]{-1,1,0,0};
         int[][] dist=new int[g.length][g[0].length];
         for(int[] di:dist)
         Arrays.fill(di,Integer.MAX_VALUE);
         dist[0][0]=0;
         pq.add(new Pair(0,0,0));
         int ans=Integer.MAX_VALUE;
         while(!pq.isEmpty())
         {
             int x=pq.peek().x;
             int y=pq.peek().y;
             int d=pq.peek().d;
             pq.remove();
             if(x==g.length-1 && y==g[0].length-1)
             return d;
             
             for(int i=0;i<4;i++)
             {
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx<0 || ny<0 || nx>=g.length || ny>=g[0].length)
                    continue;
                    int nd=Math.max(Math.abs(g[nx][ny]-g[x][y]),d);
                    if(nd<dist[nx][ny]){
                    dist[nx][ny]=nd;
                    pq.add(new Pair(nx,ny,nd));
                    }
             }
             
         }
         return ans;
    }
}