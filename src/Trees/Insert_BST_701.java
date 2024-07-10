package Trees;

public class Insert_BST_701 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Insert_BST_701 insert = new Insert_BST_701();
        TreeNode ans = insert.insertIntoBST(root, 5);
        System.out.println("Done");
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (val <= temp.val) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = new TreeNode(val);
                    break;
                }
            } else {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
