package Trees;

import java.util.ArrayList;
import java.util.List;

public class Inorder_Traversal_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Inorder_Traversal_94 inorder = new Inorder_Traversal_94();
        List<Integer> ans = inorder.inorderTraversal(root);
        System.out.println("Inorder Traversal : ");
        for (int el : ans) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        mainInorder(root, ans);
        return ans;
    }

    public void mainInorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        mainInorder(node.left, list);
        list.add(node.val);
        mainInorder(node.right, list);
    }
}
