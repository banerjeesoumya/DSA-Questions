package Trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrder_Traversal_145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PostOrder_Traversal_145 p = new PostOrder_Traversal_145();
        List<Integer> ans = p.postorderTraversal(root);
        System.out.println("Postorder Traversal : ");
        for (int el : ans) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        mainPostorder(root, ans);
        return ans;
    }

    public void mainPostorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        mainPostorder(node.left, list);
        mainPostorder(node.right, list);
        list.add(node.val);
    }
}
