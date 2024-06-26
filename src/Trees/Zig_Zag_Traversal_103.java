package Trees;

import java.util.*;

public class Zig_Zag_Traversal_103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        Zig_Zag_Traversal_103 obj = new Zig_Zag_Traversal_103();
        List<List<Integer>> res = obj.zigzagLevelOrder(root);
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean L_to_R = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (L_to_R) {
                    TreeNode node = queue.removeFirst();
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    level.add(node.val);
                } else {
                    TreeNode node  = queue.removeLast();
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    level.add(node.val);
                }
            }
            L_to_R = ! (L_to_R);
            res.add(level);
        }
        return res;
    }
}
