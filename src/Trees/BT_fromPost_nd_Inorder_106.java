package Trees;

import java.util.Arrays;
import java.util.List;

public class BT_fromPost_nd_Inorder_106 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BT_fromPost_nd_Inorder_106 bt = new BT_fromPost_nd_Inorder_106();
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode node = bt.buildTree(inorder,  postorder);
        System.out.println("Done");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        // int postLength = postorder.length - 1
        int root = postorder[postorder.length - 1];
        int index = 0;
        for (int i = 0 ; i < inorder.length; i ++) {
            if (inorder[i] == root) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(root);
        int postLength = postorder.length;
        int inLength = inorder.length;

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index),
                Arrays.copyOfRange(postorder, 0, index));

        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inLength),
                Arrays.copyOfRange(postorder, index, postLength - 1));
        return node;
    }
}
