class Solution {
    public List<String> topKFrequent(String[] w, int k) {
        List<String> l=
new ArrayList<>(); 
HashMap<String,Integer> h =new HashMap<>();
        for(int i=0;i<w.length;i++)
     h.put(w[i],h.getOrDefault(w[i],0)+1);
           
        TreeSet<String> t=new TreeSet<>((a,b)->(Integer.compare(h.get(b),h.get(a)))==0?a.compareTo(b):Integer.compare(h.get(b),h.get(a)));
        
        for(String str: h.keySet())
            t.add(str);
    
//System.out.println(h+"\n"+t);
        for(String s:t)
            if(k-->0)
                l.add(s);
        return l;
        
    }
}
