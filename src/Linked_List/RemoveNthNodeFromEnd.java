package Linked_List;

public class RemoveNthNodeFromEnd extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
        Node root;
        root = obj.construct(arr);
        obj.display(root);
        obj.removeNthFromEnd(root, 2);
        obj.display(root);
    }

    public Node removeNthFromEnd(Node root, int n) {
        Node fast = root, slow = root;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return root.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root;
    }
}
