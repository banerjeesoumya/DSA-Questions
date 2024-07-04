package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class Nodes_At_distance_k_863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Nodes_At_distance_k_863 n = new Nodes_At_distance_k_863();
        List<Integer> ans = n.distanceK(root, root.left, 2);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_Details = new HashMap<>();
        keepTrackOfParents(root, parent_Details);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) {
                break;
            }
            dist ++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    visited.put(node.left, true);
                    queue.add(node.left);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    visited.put(node.right, true);
                    queue.add(node.right);
                }
                if (parent_Details.get(node) != null && !visited.containsKey(parent_Details.get(node))) {
                    visited.put(parent_Details.get(node), true);
                    queue.add(parent_Details.get(node));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
        }
        return ans;
    }


    public void keepTrackOfParents(TreeNode root, HashMap<TreeNode, TreeNode> parent_Details) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent_Details.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent_Details.put(node.right, node);
                queue.add(node.right);
            }
        }
    }
}
