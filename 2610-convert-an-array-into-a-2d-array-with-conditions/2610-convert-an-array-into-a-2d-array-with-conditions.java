class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int mf=0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int x:nums)
        {
            h.put(x,h.getOrDefault(x,0)+1);
            mf = Math.max(mf,h.get(x));
        }
        List<List<Integer>> l = new ArrayList<>();
        for(int f=1;f<=mf;f++){
            List<Integer> ll = new ArrayList<>();
            for(Integer k : h.keySet())
                if(h.get(k)>=f)
                    ll.add(k);
            l.add(ll);
        }
        return l;
    }
}