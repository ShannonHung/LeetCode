package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return true;
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }
    public boolean recurVersion(TreeNode root){
        if(root==null) return true;
        return recurVersion2(root.left, root.right);
    }
    public static boolean recurVersion2(TreeNode left, TreeNode right){
        //left和right永遠要比對正確 也就是最左邊 跟 最右邊node
        if(left == null && right==null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return recurVersion2(left.left, right.right) && recurVersion2(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
