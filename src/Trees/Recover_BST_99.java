package Trees;

public class Recover_BST_99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        Recover_BST_99 r = new Recover_BST_99();
        r.recoverTree(root);
        System.out.println("Done");
    }

    TreeNode first;
    TreeNode prev;
    TreeNode middle;
    TreeNode last;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && middle != null) {
            swap(first.val, middle.val);
        }
        else if (first != null && last != null) {
            swap(first.val, last.val);
        }
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }
        prev = node;
        inorder(node.right);
    }
}
