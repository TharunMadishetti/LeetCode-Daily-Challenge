class Solution {
    public int[] findArray(int[] p) {
        int[] a=new int[p.length];
        int n=p.length;
        a[0]=p[0];
        for(int i=1;i<n;i++)
            a[i]=p[i-1]^p[i];
        return a;
    }
}