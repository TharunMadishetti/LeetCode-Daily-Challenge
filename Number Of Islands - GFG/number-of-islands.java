//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

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
        if(ulpu==ulpv) return;
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
    public List<Integer> numOfIslands(int rows, int cols, int[][] o) {
        //Your code here
        int V = rows*cols;
        int f=cols;
         p=new int[V];
	    for(int i=0;i<V;i++)
	    p[i]=i;
	     sz=new int[V];
	    Arrays.fill(sz,1);
	    List<Integer>  ans=new ArrayList<>();
	    int[][] g=new int[rows][cols];
	    int[] dx=new int[]{0,0,-1,1};
	    int[] dy=new int[]{-1,1,0,0};
	    int c=0;
	    for(int i=0;i<o.length;i++)
	    {
	        int x=o[i][0];
	        int y=o[i][1];
	        if(g[x][y]==1)
	        {
	             ans.add(c);
	             continue;
	        }
	        g[x][y]=1;
	        c++;
	       // boolean f=true;
	        for(int j=0;j<4;j++)
	        {
	            int nx=x+dx[j];
	            int ny=y+dy[j];
	            if(nx>=rows || nx<0 || ny<0 || ny>=cols)
	            continue;
	            if(g[nx][ny]==1)
	            {   
	                if(findp(nx*f+ny)!=findp(x*f+y))
	               {
	                    c--;
	                UnionBySize(nx*f+ny,x*f+y);
	               }
	            }
	        }
	       // for(int k=0;k<V;k++)
	       // if(g[k/cols][k%cols]==1 && p[k]==k)
	       // c++;
	        ans.add(c);
	    }
	    return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends