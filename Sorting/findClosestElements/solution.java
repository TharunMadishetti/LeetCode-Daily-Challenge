class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[][] dist=new int[arr.length][2];
        for(int i=0;i<arr.length;i++)
       {
          dist[i][0]=Math.abs(arr[i]-x);  // storing distances in the 0th index of an 2d matrix
          dist[i][1]=i;                   //storing index of element in the 1st index of an 2d matrix
        }
        Arrays.sort(dist,(a,b)->Integer.compare(a[0],b[0]));    //sort the elements according to their distances
        ArrayList<Integer> l =new ArrayList<>();
        for(int i=0;i<k;i++)
            l.add(arr[dist[i][1]]); //accessing the first m elements which have least distance from x
        Collections.sort(l);  //sorting the elements
        return l;
    }
}
