// 👇👇 To insert at beginning and at the end
package Linked_List;

public class Insert_Beginning extends Main {
    public static void main(String[] args) {
        Insert_Beginning ob = new Insert_Beginning();
        int[] arr = {2, 4, 6, 8, 10};
        Node root = null;
        root = ob.construct(arr);
        root = ob.inserAtBeginning(root, 0);
        root = ob.insertAtEnd(root, 12);
        ob.display(root);
    }

    public Node inserAtBeginning(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        return head;
    }

    public Node insertAtEnd(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = head;
        Node node = new Node(val);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        temp = temp.next;
        return head;
    }
}
