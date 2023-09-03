class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int p=0;
        int ans=0;
        if(k==0 && nums.length==1)
            return nums[0]==0?1:0;
        
        h.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            // System.out.println(h);
            p+=nums[i];
            ans+=h.getOrDefault(p-k,0);
            h.put(p,h.getOrDefault(p,0)+1); 
        }
        return ans;
    }
}