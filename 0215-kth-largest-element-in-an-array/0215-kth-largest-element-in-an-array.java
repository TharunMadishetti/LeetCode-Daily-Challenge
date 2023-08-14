class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        int l=0,r=nums.length-1,p=r;
        while(l<=r)
        {
            int x=nums[r],j=l;
            p=l;
            while(j<r)
            {
                if(nums[j]<=x)
                {
                    int t=nums[j];
                    nums[j]=nums[p];
                    nums[p]=t;
                    p++;
                }
                j++;
            } 
            nums[r]=nums[p];
            nums[p]=x;
            
            if(k==p)
                return nums[p];
            if(p<=k)
                l=p+1;
            else
                r=p-1;
        }
        return nums[p];
    }
}