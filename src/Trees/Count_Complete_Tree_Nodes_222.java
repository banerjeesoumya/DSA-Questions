package Trees;

public class Count_Complete_Tree_Nodes_222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        Count_Complete_Tree_Nodes_222 obj = new Count_Complete_Tree_Nodes_222();
        int count = obj.countNodes(root);
        System.out.println(count);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if (lh == rh) {
            int pow = (int)Math.pow(2, lh);
            return pow - 1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int getLeftHeight(TreeNode root) {
        int count = 1;
        while (root.left != null) {
            count ++;
            root = root.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode root) {
        int count = 1;
        while (root.right != null) {
            count ++;
            root = root.right;
        }
        return count;
    }
}
