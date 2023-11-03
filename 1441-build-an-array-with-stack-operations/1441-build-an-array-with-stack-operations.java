class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> l=new ArrayList<>();
        int i=1,j=0;
        while(i<=n && j<target.length){
            if(i==target[j])
            {
                l.add("Push");
                j++;
            }
            else
            {
                l.add("Push");
                l.add("Pop");
            }
            i++;
        }
        return l;
    }
}