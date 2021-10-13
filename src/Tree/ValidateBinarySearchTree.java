package Tree;

import com.sun.source.tree.Tree;

public class ValidateBinarySearchTree {
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
    public static int maxLeft = Integer.MIN_VALUE;
    public static int minRight = Integer.MAX_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root.left == null  && root.right==null) return true;
        if(root.left != null && isValidBST(root.left)){
            //用相反來表示
            if(root.val <= root.left.val) return false;
            maxLeft = Math.max(root.left.val, maxLeft);
        }
        if(root.right != null && isValidBST(root.right)){
            //用相反來表示
            if(root.val >= root.right.val) return false;
            minRight = Math.min(root.right.val, minRight);
        }
        if(minRight < root.val || maxLeft > root.val) return false;
        return true;
    }
    public static boolean isValidBST2(TreeNode root) {
        return checkNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean checkNode(TreeNode node, long min, long max) {
        if (node == null){
            return true;
        }
        if(node.val > min && node.val < max){
            //left永遠比node小 所以 node應該要成為node.left的最大 ; right會變成node永遠是最小 因此node.val擺在min位置 所以 node 會成為右邊的最小
            //如果是左邊
            return (checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max));
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode node3 = new TreeNode(5, node1, node2);

        TreeNode node4 = new TreeNode(1, new TreeNode(1), null);

        TreeNode trueA = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode falseB = new TreeNode(5, node5, node6);
        System.out.println(isValidBST2(falseB));
    }
}
