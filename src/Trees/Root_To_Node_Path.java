package Trees;

import java.util.ArrayList;
import java.util.List;

public class Root_To_Node_Path {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        Root_To_Node_Path obj = new Root_To_Node_Path();
        List<Integer> arr = obj.getPath(root, 7);
        System.out.println("Output :");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public List<Integer> getPath(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, target);
        return res;
    }

    public static boolean helper(TreeNode root, List<Integer> res, int target) {
        if (root == null) {
            return false;
        }
        res.add(root.val);
        if (root.val == target) {
            return true;
        }
        if (helper(root.left, res, target) || helper(root.right, res, target)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
