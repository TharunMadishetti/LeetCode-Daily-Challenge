/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode r, int val, int depth) {
        if(r==null)
            return null;
        depth--;
        if(depth==0)
    {
            TreeNode nr=new TreeNode(val);
            nr.left=r;
            nr.right=null;
            return nr;
        }
        if(depth==1)
        {
            TreeNode l=r.left,right=r.right;
            r.left=new TreeNode(val);
            r.right=new TreeNode(val);
            r.left.left=l;
            r.right.right=right;
            return r;
        }
        r.left=addOneRow(r.left,val,depth);
        r.right=addOneRow(r.right,val,depth);
        return r;
    }
}
