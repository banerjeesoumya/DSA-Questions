package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zig_Zag_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Zig_Zag_Traversal obj = new Level_Order_Traversal_102();
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    }
}
