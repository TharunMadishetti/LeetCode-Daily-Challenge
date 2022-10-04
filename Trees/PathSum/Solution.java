class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;

      return  p(root,targetSum);

    }

    public boolean p(TreeNode root,int t)

    {
        if(root==null)
            return false;

        if(root.right==null && root.left==null && t==root.val)
            return true;
        
       boolean r= p(root.left,t-root.val);

      boolean l=  p(root.right,t-root.val);

        

        return (r || l) ;

    

    }
}
