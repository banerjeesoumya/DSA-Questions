package Trees;

public class Max_Path_Sum_124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        Max_Path_Sum_124 m = new Max_Path_Sum_124();
        int maxSum = m.maxPathSum(root);
        System.out.println(maxSum);
    }

    public int maxPathSum(TreeNode node) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        height(node, maxSum);
        return maxSum[0];
    }

    public int height(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int lh = Math.max(0, height(node.left, maxSum));
        int rh = Math.max(0, height(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], lh + rh + node.val);
        return Math.max(lh, rh) + node.val;
    }
}
