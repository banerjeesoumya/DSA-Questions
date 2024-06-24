package Trees;

public class Maximum_Depth_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Maximum_Depth_104 m = new Maximum_Depth_104();
        int height = m.maxDepth(root);
        System.out.println(height);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return Math.max(lh, rh) + 1;
    }
}
