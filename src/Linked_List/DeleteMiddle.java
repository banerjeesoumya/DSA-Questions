package Linked_List;

public class DeleteMiddle extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 1, 2, 6};
        DeleteMiddle dm = new DeleteMiddle();
        Node root;
        root = dm.construct(arr);
        dm.display(root);
        dm.deleteMiddle(root);
        dm.display(root);
    }

    public Node deleteMiddle(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node fast = root, slow = root;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return root;
    }
}
