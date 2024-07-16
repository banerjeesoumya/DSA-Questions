package Trees;

import java.util.Stack;

public class TwoSum_IV_653 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TwoSum_IV_653 twoSum = new TwoSum_IV_653();
        System.out.println(twoSum.findTarget(root, 9));
    }

    public boolean findTarget(TreeNode root, int k) {
        BST_Iterator2 n = new BST_Iterator2(root, false);
        BST_Iterator2 b = new BST_Iterator2(root, true);

        int i = n.next();
        int j = b.next();

        while (i < j) {
            if ((i + j) == k) {
                return true;
            } else if ((i + j) < k) {
                i = n.next();
            } else {
                j = b.next();
            }
        }
        return false;
    }
}

class BST_Iterator2 {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;

    public BST_Iterator2(TreeNode node, boolean isReverse) {
        this.reverse = isReverse;
        pushAll(node);
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (reverse == false) {
            pushAll(temp.right);
        }
        else {
            pushAll(temp.left);
        }
        return temp.val;
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse == false) {
                node  = node.left;
            } else {
                node = node.right;
            }
        }
    }

}
