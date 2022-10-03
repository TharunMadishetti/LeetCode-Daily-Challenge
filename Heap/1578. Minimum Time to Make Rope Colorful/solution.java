class Solution {
    public int minCost(String c, int[] t) {
        if(t.length==1)
            return 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // to maintain the times of consecutive elements and get maximum time of consecutive balloons
        pq.add(t[0]);
        int ans=t[0];
      for(int i=1;i<t.length;i++)
      {
        // System.out.println(i+"s "+pq + " "+ans);

          if(c.charAt(i-1)==c.charAt(i))    //if this color is same as previous then keep on adding them into the queue
          {
              pq.add(t[i]);
          }
          else
          {
              ans-=pq.poll();   //now we need to keep leave only that particular balloon which takes maximum time to remove hence we'll remove the maximum time needed balloon out of this
              pq.clear(); //now let's start from the start as present color is diff previous color balloons doesn't influence present color
              pq.add(t[i]); //again start adding these balloons 
          }
          ans+=t[i];    //we add time needed for all balloons if they are consecutive then we'll leave only maximum time needed balloon
            // System.out.println(i+" "+pq + " "+ans);

      }
        ans-=pq.poll();   //queue still could not be empty there could be atleast last balloon or consecutive which are till the last index
        return ans;
    }
}
