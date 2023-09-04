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
    public int findCircleNum(int[][] g) {
        int V=g.length; 
        p=new int[V];
	    for(int i=0;i<V;i++)
	    p[i]=i;
	     sz=new int[V];
	    Arrays.fill(sz,1);
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[0].length;j++)
            {
                if(g[i][j]==1)
                {
                    UnionBySize(i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<g.length;i++)
            if(p[i]==i)
                c++;
        return c;
    }
}