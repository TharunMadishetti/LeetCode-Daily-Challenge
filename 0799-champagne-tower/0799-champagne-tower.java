class Solution {
     public double champagneTower(int p, int qr, int qg) {
    double[][] A = new double[102][102];
        A[0][0] = (double) p;
        for (int r = 0; r <= qr; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1, A[qr][qg]);
     }
//     public double champagneTower(int p, int qr, int qg) {
//         if(p==0)
//             return 0;
//         if(p>50*(101))
//             return 1.0;
//         qr++;
//         qg++;
//         int full=find(p);
//         int rem=p-full*(full+1)/2;
//         System.out.println(full+" "+rem+" "+qr);
//         if(qr<=full)
//             return 1.0;
//         if(qr>full+1)
//             return 0.0;
        
//         if(qg==1 || qg==full+1)
//             return rem/(float)Math.pow(2,full);
//         return rem/(float)Math.pow(2,full-1);
//     }
//     public int find(int x)
//     {
//         int l=1,r=100,ans=100;
//         while(l<=r)
//         {
//             int m=(l+r)/2;
//             if(m*(m+1)/2<=x)
//             {
//                 ans=m;
//                 l=m+1;
//             }
//             else 
//                 r=m-1; 
//         }
//         return ans;
    
}