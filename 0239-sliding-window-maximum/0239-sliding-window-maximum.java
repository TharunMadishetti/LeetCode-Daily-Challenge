class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int i=0;
        while(i<k)
        {
            // System.out.println(q);
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();
            q.addLast(i);
            i++;
        }
        int j=0;
        int[] ans=new int[nums.length-k+1];
        while(i<nums.length)
        {
           ans[j++]=nums[q.peekFirst()];
            while(!q.isEmpty() && i-q.peekFirst()>=k)
               q.pollFirst();
           while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();
            
            q.addLast(i);
            i++;
        }
         ans[j++]=nums[q.peekFirst()];
        return ans;
    }
}