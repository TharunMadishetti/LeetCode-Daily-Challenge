class Solution {
    public int numBusesToDestination(int[][] r, int src, int t) {
        ArrayList<HashSet<Integer>> h=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        HashSet<String> v=new HashSet<>();
        for(int i=0;i<r.length;i++){
            HashSet<Integer> hh = new HashSet<>();
            for(int x:r[i])
                hh.add(x);
            h.add(hh);
        }
        HashSet<Integer> qq=new HashSet<>();
        q.add(src+" "+0);
        v.add(src+" "+0);
        while(!q.isEmpty())
        {
            String[] str = q.poll().split(" ");
            int curr = Integer.parseInt(str[0]);            
            int bus = Integer.parseInt(str[1]);
            if(curr==t)
                return bus;
            for(int i=0;i<r.length;i++){
            if(!h.get(i).contains(curr) || qq.contains(i))
                continue;
            for(int c : h.get(i))
            {
                if(v.contains(c+" "+(bus+1)))
                    continue;
                v.add(c+" "+(bus+1));
                q.add(c+" "+(bus+1));
            }
                qq.add(i);
            }
           
        }
        return -1;
    }
}