package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        //表示超過控制範圍 所以新增linked
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        //表示仍在控制範圍
        res.get(height).add(root.val);
        //return 的時候height會回復原狀
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), node1);
        levelOrder(root);
    }
}
