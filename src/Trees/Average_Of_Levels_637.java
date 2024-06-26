package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_Of_Levels_637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Average_Of_Levels_637 a = new Average_Of_Levels_637();
        List<Double> ans = a.averageOfList(root);
        for (double el : ans) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public List<Double> averageOfList(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            double avg = sum / size;
            ans.add(avg);
        }
        return ans;
    }
}
