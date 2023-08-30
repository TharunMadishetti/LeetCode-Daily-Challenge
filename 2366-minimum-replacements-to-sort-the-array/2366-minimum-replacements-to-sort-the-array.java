class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0;
        int i=nums.length-1;
        int p=nums[i];
        i--;
        while(i>=0)
        {
            if(nums[i]>nums[i+1])
            {
                long x = ((long)(nums[i]+nums[i+1]-1))/(long)nums[i+1];
                ans+=x-1;
                nums[i]=nums[i]/(int)x;
            }
            
            i--;
        }
        
        return ans;
    }
}