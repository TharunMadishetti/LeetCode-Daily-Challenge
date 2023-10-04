class MyHashMap { 
    class Pair 
        { 
        Integer key; 
        Integer value; 
        Pair(Integer k,Integer v) 
            {
            key=k; 
            value=v;
            }
   
        } 
    ArrayList<Pair> map= new ArrayList<>();

    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        Pair p1= new Pair(key,value); 
        int i=get(key);
        if(i==-1)
        map.add(p1);
        else 
            update(key,value);
    }
    
    public int get(int key) {
        for(Pair p:map) 
            {
            if(p.key==key)
                return p.value; 
            } 
        return -1;
    } 
    public void update(int key,int value) 
        {
        
        for(Pair p:map) 
            {
            if(p.key==key)
              {  p.value=value;
               return; }
            } 
       
        
        }
    
    public void remove(int key) { 
    for(int i=map.size()-1;i>=0;i--)
        { 
        
        
        Pair p=map.get(i);
        if(p.key==key)
            { 
            map.remove(i); 
            return;}
        
        } 
        }



    
        
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */