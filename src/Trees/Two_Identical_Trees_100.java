package Trees;

public class Two_Identical_Trees_100 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        Two_Identical_Trees_100 tree = new Two_Identical_Trees_100();
        boolean identical = tree.isSameTree(root1, root2);
        System.out.println(identical);
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return (node1 == node2);
        }
        return (isSameTree(node1.left, node2.left) &&
               (node1.val == node2.val) &&
               isSameTree(node1.right, node2.right));
    }
}
