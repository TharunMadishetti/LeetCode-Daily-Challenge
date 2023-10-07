class Solution {
    public int jump(int[] nums) {
        int i=0,mx=0,curr=0,c=0;
        while(i<nums.length-1)
        {
            mx=Math.max(mx,i+nums[i]);
            if(i==curr)
            {
                curr=mx;
                c++;
            }
            
            i++;
        }
        return c;
    }
}