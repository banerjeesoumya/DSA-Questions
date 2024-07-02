    package Trees;

    import java.util.LinkedList;
    import java.util.Queue;

    public class Maximum_Width_662 {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(9);

            Maximum_Width_662 obj = new Maximum_Width_662();
            int ans = widthOfBinaryTree(root);
            System.out.println(ans);
        }

        public static int widthOfBinaryTree(TreeNode root) {
            class Pair {
                TreeNode node;
                int num;

                Pair(TreeNode node, int val) {
                    this.node = node;
                    this.num = val;
                }
            }
            if (root == null) {
                return 0;
            }
            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
//            Starting off with the root and thereby root is at the 0th index
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                int min = q.peek().num;
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    int curr_Id = q.peek().num - min;
                    TreeNode node  = q.peek().node;
                    q.poll();
                    if (i == 0) {
                        first = curr_Id;
                    }
                    if (i == size - 1) {
                        last = curr_Id;
                    }
                    if (node.left != null) {
                        q.add(new Pair(node.left, (2 * curr_Id + 1)));
                    }
                    if (node.right != null) {
                        q.add(new Pair(node.right, (2 * curr_Id + 2)));
                    }
                }
                ans = Math.max(ans, (last - first + 1));
            }
            return ans;
        }
    }
