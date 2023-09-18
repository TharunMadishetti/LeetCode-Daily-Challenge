class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int f[] = new int[mat.length];
        int v[]=new int[mat.length];
        for(int i=0;i<mat.length;i++)
            { int c=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    c++;
                }
                else 
                    break;
            }
        f[i]=c; 
        v[i]=i;
        
    } 
      for(int i=0;i<f.length;i++)
          for(int j=0;j<f.length;j++)
              {
              
              if(f[i]<f[j] || (f[j]==f[i] && v[i]<v[j]))
                  {
                  
                  int t=f[j];
                  f[j]=f[i];
                  f[i]=t;
                  
                  
                  t=v[j];
                  v[j]=v[i];
                  v[i]=t;
                  
                  
                  
                  }
              
              
              
              }
          
        System.out.println(Arrays.toString(f));
    int fr[]= new int[k]; 
        int min=0;
    for(int i=0;i<k;i++)
        {
           fr[i]=v[min++];
        }
      // Arrays.sort(fr);
    return fr;
    }
}