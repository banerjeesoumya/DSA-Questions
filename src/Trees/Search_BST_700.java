package Trees;

import com.sun.source.tree.Tree;

public class Search_BST_700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Search_BST_700 bst = new Search_BST_700();
        TreeNode node = searchNodes(root, 2);
        System.out.println("Done");
    }

    public static TreeNode searchNodes(TreeNode node, int target) {
        while ((node != null) && (node.val != target)) {
            node = (target < node.val) ? node.left : node.right;
        }
        return node;
    }
}
