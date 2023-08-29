class Solution {
    public int bestClosingTime(String c) {
        int[] y=new int[c.length()];
        if(c.charAt(c.length()-1)=='Y')
            y[y.length-1]=1;
        for(int i=c.length()-2;i>=0;i--)
            y[i]=y[i+1]+(c.charAt(i)=='Y'?1:0);
        int ans=Integer.MAX_VALUE;
        int n=0,idx=-1;
        // System.out.println(Arrays.toString(y));
        for(int i=0;i<c.length();i++)
        {
            if(n+y[i]<ans)
            {
                ans=n+y[i];
                idx=i;
            }
            if(c.charAt(i)=='N')
                n++; 
        }
        if(n<ans)
        {
            ans=n;
            idx=c.length();
        }
        return idx;
    }
}