package Trees;

public class Delete_BST_450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);

        Delete_BST_450 del = new Delete_BST_450();
        TreeNode ans = del.deleteNode(root, 3);
        System.out.println("Done");
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return help(root);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (key < temp.val) {
                if (temp.left != null && temp.left.val == key) {
                    temp.left = help(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.val == key) {
                    temp.right = help(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }

    public TreeNode help(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }
        TreeNode rightChild = node.right;
        TreeNode lastRightOnLeft = find(node.left);
        lastRightOnLeft.right = rightChild;
        return node.left;
    }

    public TreeNode find(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return find(node.right);
    }
}
