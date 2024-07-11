package Trees;

public class LCA_BST_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        LCA_BST_235 bst = new LCA_BST_235();
        System.out.println(bst.lowestCommonAncestor(root, root.left, root.right).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int main_Val = root.val;
        if (p.val > main_Val && q.val > main_Val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < main_Val && q.val < main_Val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
