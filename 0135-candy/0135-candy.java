class Solution {
    public int candy(int[] r) {
        int l=r.length;
        int[] c=new int[l];
        Arrays.fill(c,1);
        if(l==1)
            return 1;
        int ans=0;
        for(int i=1;i<r.length;i++)
        {
            if(r[i]>r[i-1] && c[i]<=c[i-1])
                c[i]+=c[i-1]-c[i]+1;
        }
        for(int i=l-2;i>=0;i--)
        {
            if(r[i]>r[i+1] && c[i]<=c[i+1])
                c[i]+=c[i+1]-c[i]+1;
            ans+=c[i];
        }
        ans+=c[l-1];
        return ans;
    }
}