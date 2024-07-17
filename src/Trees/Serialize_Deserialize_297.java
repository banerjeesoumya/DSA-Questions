package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize_297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Serialize_Deserialize_297 obj = new Serialize_Deserialize_297();
        String res = obj.serialize(root);
        TreeNode des = obj.deserialize(res);
        System.out.println(res);
        System.out.println(des.val);
    }

    public String serialize(TreeNode root) {
        if (root == null){
            return " ";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] value = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        queue.add(root);
        for (int  i = 1; i < value.length; i++){
            TreeNode node = queue.poll();
            if (!value[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                node.left = left;
                queue.add(left);
            }
            if (!value[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
