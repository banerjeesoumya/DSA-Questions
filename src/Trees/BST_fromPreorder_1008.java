package Trees;

import java.util.List;

public class BST_fromPreorder_1008 {
    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        BST_fromPreorder_1008 bst = new BST_fromPreorder_1008();
        TreeNode ans = bst.bstFromPreorder(preorder);
        PreOrder_Traversal_144 preOrderTraversal = new PreOrder_Traversal_144();
        List<Integer> ansList = preOrderTraversal.preOrder(ans);
        System.out.println("Preorder Traversal : ");
        for (int el : ansList) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return construction(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode construction(int[] arr, int bound, int[] a) {
        if (a[0] == arr.length || arr[a[0]] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(arr[a[0]]);
        a[0] = a[0] + 1;
        node.left = construction(arr, node.val, a);
        node.right = construction(arr, bound, a);

        return node;
    }
}
