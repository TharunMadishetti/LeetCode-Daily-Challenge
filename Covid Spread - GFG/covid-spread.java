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
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    class Pair
    {
        int t,x,y;
        Pair(int t,int x,int y)
        {
            this.t=t;
            this.y=y;
            this.x=x;
        }
    }
     public int helpaterp(int[][] h) {
        // code here
        int c=0;
        
         Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<h.length;i++)
        for(int j=0;j<h[0].length;j++)
        if(h[i][j]==1)c++;
        else if(h[i][j]==2)
        q.add(new Pair(0,i,j));
        int t=0;
        while(!q.isEmpty())
        {
            int x=q.peek().x;
            int y=q.peek().y;
            t=q.peek().t;
            q.poll();
            int[] dx=new int[]{0,0,-1,1};
            int[] dy=new int[]{-1,1,0,0};
            for(int k=0;k<4;k++)
            {
                int nx=x+dx[k],ny=y+dy[k];
                if(nx>=0 && ny>=0 && nx<h.length && ny<h[0].length && h[nx][ny]==1)
                {
                    h[nx][ny]=2;
                    q.add(new Pair(t+1,nx,ny));
                    c--;
                }
            }
        }
        // for(int i=0;i<h.length;i++)
        // for(int j=0;j<h[0].length;j++)
        // System.out.println(Arrays.toString(h[i]));
        if(c==0)
        return t;
        return -1;
    }
}
