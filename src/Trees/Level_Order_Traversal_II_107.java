package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Order_Traversal_II_107 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Level_Order_Traversal_II_107 obj = new Level_Order_Traversal_II_107();
        List<List<Integer>> res = obj.levelOrder(root);
        System.out.println("Output :");
        for (List<Integer> level : res) {
            printList(level);
        }
    }
    public static void printList(List<Integer> level) {
        for (int num : level) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            res.add(0, level);
        }
        return res;
    }
    }
