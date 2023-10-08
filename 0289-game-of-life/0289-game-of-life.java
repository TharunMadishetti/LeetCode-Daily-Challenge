class Solution {
    public void gameOfLife(int[][] b) {
        int[] dx=new int[]{-1,-1,-1,0,0,1,1,1};
        int[] dy=new int[]{-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[i].length;j++)
            {
                int l=0;
                for(int k=0;k<8;k++){
                 int x=dx[k],y=dy[k];
                    if(i+x>=0 && j+y>=0 && i+x<b.length && j+y<b[i+x].length && b[i+x][y+j]%2==1)
                        l++;
                }
                if(b[i][j]==1)
                {
                    if(l<2)
                    b[i][j]+=0;
                else if(l<4)
                    b[i][j]+=2;
                else
                    b[i][j]+=0;
                }
                else
                if(l==3)
                    b[i][j]+=2;
                // System.out.print(b[i][j]+" "+l);
            }
            // System.out.println();
            
        }
        for(int i=0;i<b.length;i++)
            for(int j=0;j<b[i].length;j++)
                    b[i][j]/=2;
            
        
    }
}