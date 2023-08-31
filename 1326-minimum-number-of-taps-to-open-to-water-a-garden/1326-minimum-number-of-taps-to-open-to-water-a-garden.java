class Solution {
    public int minTaps(int n, int[] r) {
        int[][] a=new int[r.length][2];
        for(int i=0;i<r.length;i++)
        {
            a[i][0]=Math.max(0,i-r[i]);
            a[i][1]=Math.min(n,i+r[i]);
        }
        Arrays.sort(a,(x,y)->(x[0]!=y[0]?Integer.compare(x[0],y[0]):Integer.compare(y[1],x[1])));
        int end=a[0][1],mx=a[0][1];
        int i=1;
        while(i<a.length)
        {
            int c=-1;
            while(i<a.length && a[i][0]<=end)
            {
                if(a[i][1]<=end)
                {
                    i++;
                    continue;
                }
                a[i][0]=end;
                c=Math.max(a[i][1],c);
                i++;
            }
            if(c==-1)
                i++;
            else
               end=c;
        }
        Arrays.sort(a,(x,y)->(x[0]!=y[0]?Integer.compare(x[0],y[0]):Integer.compare(y[1],x[1])));
        int e=a[0][1];
        int t=1;
        i=1;
        while(i<r.length)
        {
            // System.out.println(a[i][0]+" "+a[i][1]);
            if(a[i][0]<=e && a[i][1]>e)
            {
                e=a[i][1];
                t++;
            }
            i++;
        }
        if(e<n)
            return -1;
        return t;
    }
}