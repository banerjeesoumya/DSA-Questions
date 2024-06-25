package Trees;

public class Diameter_of_Binary_Tree_543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Diameter_of_Binary_Tree_543 d = new Diameter_of_Binary_Tree_543();
        int diam = d.diameterOfBinaryTree(root);
        System.out.println(diam);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    public int height(TreeNode root, int [] diameter) {
        if (root == null) return 0;
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }
}
