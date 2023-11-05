class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int mx=arr[0];
        for(int x:arr)
        {
            q.add(x);
            mx=Math.max(mx,x);
        }
        
        int p=-1,c=0;
        while(k<arr.length)
        {
            int x = q.pollFirst();
            int y = q.pollFirst();
            int w=Math.max(x,y),l=Math.min(x,y);
            q.addFirst(w);
            q.addLast(l);
            if(p==w)
                c++;
            else
                c=1;
            p=w;
            if(c==k)
                return w;
        }
        return mx;
    }
}