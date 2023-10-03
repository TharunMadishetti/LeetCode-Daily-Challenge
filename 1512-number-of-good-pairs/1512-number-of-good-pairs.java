class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> h=new HashMap<>();
        for(int x:nums)
            h.put(x,h.getOrDefault(x,0)+1);
        int ans=0;
        for(int x:h.values())
            ans+=x*(x-1)/2;
        return ans;
    }
}
