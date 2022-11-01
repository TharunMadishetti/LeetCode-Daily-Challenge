//Problem link: https://leetcode.com/problems/where-will-the-ball-fall/
class Solution {
    public int[] findBall(int[][] g)
    {
        int[] ans =new int[g[0].length];
        int c=0;
        while(c<ans.length)
       {
         int i=0,j=c;
         boolean f=true;
         while(f && i<g.length)
         {
             
             // System.out.println("intial: " +i+" "+j);
             if(g[i][j]==1)
             {
                 if(j+1<g[0].length)
                 {
                     if(g[i][j+1]==1)
                         j++;
                     else 
                         f=false;
                 }
                 else 
                 {
                     f=false;
                 }
             }
             else 
             {
                 if(j-1>=0)
                 {
                     if(g[i][j-1]==-1)
                         j--;
                     else 
                         f=false;
                 }
                 else 
                     f=false;
             }
             i++;
             // System.out.println("final: " +i+" "+j);
             
             if(j<0 || j>=g[0].length)
                 break;
         }
        if(f)
            ans[c]=j;
         else 
             ans[c]=-1;
           c++;
        i++;
       }
       return ans;
    }
}
