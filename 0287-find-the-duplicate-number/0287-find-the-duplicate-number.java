class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length)
        {
            if(nums[i]!=i+1)
            {
                int t = nums[nums[i]-1];
                if(nums[nums[i]-1]==nums[i])
                    return nums[i];
                nums[nums[i]-1]=nums[i];
                nums[i]=t;
            }
            else
                i++;
        }
        return nums[0];
    }
}