class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int key=nums[0],c=1;
        List<Integer> l=new ArrayList<>();
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        for(int k:h.keySet())
            if(h.get(k)>nums.length/3)
                l.add(k);
        return l;
    }
}