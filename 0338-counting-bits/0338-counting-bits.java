class Solution {
    public int[] countBits(int n) {
        
        int[] d = new int[n+1];
        d[0]=0;
        if(n==0)
            return d;
        d[1]=1;
        int j=0;
        for(int i=2;i<=n;i++)
        {
           if((i&(i-1))==0)
           {
               j=0;
               
           }
          d[i]=d[j++]+1;
        }
        return d;
    }
}