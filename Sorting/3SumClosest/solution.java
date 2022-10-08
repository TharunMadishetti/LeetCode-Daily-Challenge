class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE,ans=0;
        for(int i=0;i<nums.length-2;i++)
        {
           int j=i+1,k=nums.length-1;
            while(j<k)
            {
                int curr_sum=nums[i]+nums[j]+nums[k];
                if(curr_sum==target)
                    return target;
                int curdiff=Math.abs(target-curr_sum);
                if(diff>curdiff)
                {
                    diff=curdiff;
                    ans=curr_sum;
                }
                if(curr_sum>target)
                    k--;
                else 
                    j++;
            }
            
        }
        return ans;
    }
    
}
