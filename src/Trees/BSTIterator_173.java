package Trees;

import java.util.Stack;

public class BSTIterator_173 {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator_173(TreeNode root) {
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode temp= stack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
