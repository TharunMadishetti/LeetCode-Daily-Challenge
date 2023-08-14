class Solution {
    public int numSubseq(int[] a, int t) {
        int l=0,r=a.length-1;
        Arrays.sort(a);
        long c=0;
        int mod=(int)(1e9+7);
        int[] p=new int[a.length];
        p[0]=1;
        for(int i=1;i<a.length;i++)
            p[i]=((p[i-1]%mod)*2)%mod;
        while(l<=r)
        {
            int s=a[l]+a[r];
            if(s<=t)
            {
                c=(c%mod + p[r-l]%mod)%mod;
                l++;
            }
            else if(s>t)
                r--;
        }
        return (int)c%mod;
    }
}