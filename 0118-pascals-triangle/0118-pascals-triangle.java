class Solution {
    public List<List<Integer>> generate(int r) {
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        int[][] arr = new int[r][r];
        for(int i=0;i<r;i++)
        {
            li.add(new ArrayList<Integer>());
            for(int j=0;j<=i;j++)
            {
                li.get(i).add(pascal(i,j,arr));
            }
        }
        return li;
    }
    public int pascal(int i,int j,int arr[][])
    {
        if(i==0 && j==0)
        {
            arr[i][j]=1;
         return 1;
        }
        if(j==0 || j==i)
        {
            arr[i][j]=1;
            return 1;
        }
            if(arr[i-1][j-1]==0)
            {
               arr[i-1][j-1]=pascal(i-1,j-1,arr); 
            }
         if(arr[i-1][j]==0)
            {
               arr[i-1][j]=pascal(i-1,j,arr); 
            }
         
        //2,1 = 1,0 + 1,1
        return arr[i-1][j]+arr[i-1][j-1];
    }
}