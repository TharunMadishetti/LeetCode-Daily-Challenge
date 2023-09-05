class Solution {
    // int[] p;
    // int[] r;
    // public void ubs(int x,int y)
    // {
    //     int px=findp(x);
    //     int py=findp(y);
    //     if(px==py)
    //         return ;
    //     if(r[px]>r[py])
    //     {
    //         p[px]=py;
    //     }
    //     else if(r[px]<r[py])
    //     {
    //         p[py]=px;
    //     }
    //     else
    //     {
    //         p[px]=py;
    //         r[py]++;
    //     }
    // }
    // public int findp(int x)
    // {
    //     if(p[x]==x)
    //         return x;
    //     return p[x]=find(p[x]);
    // }
    public List<Integer> findMinHeightTrees(int n, int[][] e) {
        List<Integer> ans=new ArrayList<>();
        if(n==1)
        {
            ans.add(0);
            return ans;
        }
        Queue<Integer> q=new LinkedList<>();
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++)
        g.add(new ArrayList<>());
        int[] in=new int[n];
        
        for(int i=0;i<e.length;i++)
        {
            int u=e[i][0];
            int v=e[i][1];
            in[u]++;
            in[v]++;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        for(int i=0;i<n;i++)
            if(in[i]==1)
                q.add(i);
        while(!q.isEmpty())
        {
            int l=q.size();
            ans=new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                int node=q.poll();
                ans.add(node);
                for(int k:g.get(node))
                    if((--in[k])==1)
                        q.add(k);
            }
            if(q.isEmpty())
                return ans;
        }
        return ans;
    }
}