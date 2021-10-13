package Tree;

import com.sun.source.tree.Tree;

import java.util.Optional;

public class MaximumDepthOfBinaryTree {
    public static int cur = 1;
    public static int max = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int bestSolution(TreeNode root) {
        if (root==null) return 0;
        cur = Math.max(bestSolution(root.left),bestSolution(root.right));
        cur +=1;
        return cur;
    }

    /**
     * speed: 16.77
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left==null){
            if(max < cur) max = cur;
            return max;
        }
        if(root.left != null){
            cur++;
            maxDepth(root.left);
            cur--;
        }
        if(root.right != null){
            cur++;
            maxDepth(root.right);
            cur--;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(5), new TreeNode(1));
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node3 = new TreeNode(3, null, new TreeNode(6));
        TreeNode node4 = new TreeNode(-1, null, new TreeNode(8));
        TreeNode node5 = new TreeNode(4, node3, node4);
        TreeNode root = new TreeNode(0, node2, node5);
        System.out.println(bestSolution(root));
    }
}
