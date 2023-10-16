class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l=new ArrayList<>();
        l.add(1);
        for(int r=1;r<=rowIndex;r++)
        {
            List<Integer> t=new ArrayList<>();
            t.add(1);
            if(l.size()>1)
            {
                for(int i=0;i<l.size()-1;i++)
                    t.add(l.get(i)+l.get(i+1));
            }
            t.add(1);
            l=t;
        }
        
        return l;
    }
    
}