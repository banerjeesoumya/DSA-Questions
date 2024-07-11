package Trees;

public class Kth_smallest_230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Kth_smallest_230 obj = new Kth_smallest_230();
        int res = obj.kthSmallestElement(root, 3);
        System.out.println(res);
    }

    public int kthSmallestElement(TreeNode root, int k) {
        return takingHelp(root, k).val;
    }

    int count = 0;

    public TreeNode takingHelp(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode left = takingHelp(root.left, k);
        if (left != null) {
            return left;
        }
        count += 1;
        if (count == k) {
            return root;
        }
        return takingHelp(root.right, k);
    }
}
