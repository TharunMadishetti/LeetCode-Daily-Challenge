class Solution {
    public List<List<Integer>> getSkyline(int[][] b) {
        List<List<Integer>> l= new ArrayList<>();
        int[][] bp= new int[b.length*2][3];
        int idx=0;
        for(int i=0;i<b.length;i++)
        {
            bp[idx][0]=b[i][0];
            bp[idx][1]=b[i][2];
            bp[idx][2]=0;
            bp[idx+1][0]=b[i][1];
            bp[idx+1][1]=b[i][2];
            bp[idx+1][2]=1;
            idx+=2;
        }
       
        Arrays.sort(bp,(a,c)->
                    ((a[0]==c[0])?(a[1]!=c[1]?Integer.compare(c[1],a[1]):Integer.compare(a[2],c[2])):Integer.compare(a[0],c[0])));
        // for(int[] k : bp)
        // System.out.println(Arrays.toString(k));
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> ll=new ArrayList<>();
        ll.add(bp[0][0]);
        ll.add(bp[0][1]);
        l.add(ll);
        int ph=bp[0][1];
        pq.add(bp[0][1]);
        pq.add(0);
        for(int i=1;i<bp.length;i++)
        {
             ll=new ArrayList<>();
            if(bp[i][2]==0)
            {
                
                int pmax=pq.peek();
                pq.add(bp[i][1]);
               if(pmax<pq.peek())
               {
                   ll.add(bp[i][0]);
                   ll.add(pq.peek());
                   l.add(ll);
               }
            }
           else
           {
               int pmax=pq.peek();
               pq.remove(bp[i][1]);
               idx=i+1;
               while(idx<bp.length && bp[idx][0]==bp[i][0] && pq.peek()==bp[idx][1] && bp[idx][2]==1)
               {
                   pmax=pq.peek();
                   pq.remove(bp[idx][1]);
                   i++;
                   idx++;
               }
               
               if(pmax==pq.peek())
               {
                   continue;
               }
               else
               {
                   ll.add(bp[i][0]);
                   ll.add(pq.peek());
                   l.add(ll);
               }
           }
            
        }
        return l;
    }
   
}
