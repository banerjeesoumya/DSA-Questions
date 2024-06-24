package Trees;

import java.util.ArrayList;
import java.util.List;

public class PreOrder_Traversal_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PreOrder_Traversal_144 p = new PreOrder_Traversal_144();
        List<Integer> ans = p.preOrder(root);
        System.out.println("Preorder Traversal : ");
        for (int el : ans) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        mainPreorder(root, ans);
        return ans;
    }

    public void mainPreorder (TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        mainPreorder(node.left, list);
        mainPreorder(node.right, list);
    }
}
