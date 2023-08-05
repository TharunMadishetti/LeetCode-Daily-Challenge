//https://leetcode.com/problems/unique-binary-search-trees-ii/
class Solution {
    HashMap<Integer,HashMap<Integer,List<TreeNode>>> h;
    public List<TreeNode> generateTrees(int n) {
        h=new HashMap<>();
        return generate(1,n);
    }
    public List<TreeNode> generate(int i,int j)
    {
        if(h.containsKey(i) && h.get(i).containsKey(j))
            return h.get(i).get(j);
        List<TreeNode> l=new ArrayList<>();
        if(i>j)
            return l;
        if(i==j)
        {
            l.add(new TreeNode(i));
            return l;
        }
        // TreeNode r;
        for(int k=i;k<=j;k++)
        {
            List<TreeNode> left=generate(i,k-1);
            if(left.size()==0)
                left.add(null);
            List<TreeNode> right=generate(k+1,j);
            if(right.size()==0)
                right.add(null);
            
            for(TreeNode le:left)
                for(TreeNode ri:right)
                {
                    TreeNode r=new TreeNode(k);
                    r.left=le;
                    r.right=ri;
                    l.add(r);
                }
        }
        if(!h.containsKey(i))
            h.put(i,new HashMap<>());
        h.get(i).put(j,l);
        return l;
    }
}
