//At first I thought, I need to store the elements in a priorityqueue but you don't need to as you just need one max value of the same group


class Solution {
    public int minCost(String c, int[] t) {
        if(t.length==1)
            return 0;
        int pq=t[0];
        int ans=t[0];
      for(int i=1;i<t.length;i++)
      {
        // System.out.println(i+"s "+pq + " "+ans);

          if(c.charAt(i-1)==c.charAt(i))
          {
              pq=Math.max(pq,t[i]);
          }
          else
          {
              ans-=pq;
              pq=t[i]; 
          }
          ans+=t[i];
            // System.out.println(i+" "+pq + " "+ans);

      }
        ans-=pq;
        return ans;
    }
}
