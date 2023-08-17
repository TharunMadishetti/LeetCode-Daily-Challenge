class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> temp;
        int i=1,l=1;
        temp.push_back(nums[0]);
        while(i<nums.size())
        {
            if(temp[l-1]<nums[i])
            {
                temp.push_back(nums[i]);
                l++;
            }
            else
            {
                int idx=lower_bound(temp.begin(),temp.end(),nums[i])-temp.begin();
                temp[idx]=nums[i];
            }
            i++;
        }
        return temp.size();
    }
};