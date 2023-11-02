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
    int c;
    public int averageOfSubtree(TreeNode root) {
        c=0;
        sol(root);
        return c;
    }
    public int[] sol(TreeNode r)
    {
        if(r==null)
            return new int[]{0,0};
        int[] lr=sol(r.left);
        int[] rr=sol(r.right);
        if(rr[1]==0 && lr[1]==0)
        {
            
                c++;
            return new int[]{r.val,1};
        }
        int avg = (r.val+lr[0]+rr[0])/(1+lr[1]+rr[1]);
        
        if(r.val==avg)
            c++;
        return new int[]{lr[0]+rr[0]+r.val,1+lr[1]+rr[1]};
    }
}