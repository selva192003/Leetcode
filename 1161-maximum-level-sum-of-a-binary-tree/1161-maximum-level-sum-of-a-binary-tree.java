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
    public int maxLevelSum(TreeNode root) {
        int level=0;
        int curr_level=1;
        int max=Integer.MIN_VALUE;
        Queue <TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int ans=0;
            for(int i=0;i<size;i++){
                TreeNode value=queue.remove();
                ans+=value.val;
                if(value.left!=null) queue.add(value.left);
                if(value.right!=null) queue.add(value.right);
            }
            if(ans>max){
                max=ans;
                level=curr_level;
            }
            curr_level++;
        }
        return level;
    }
}