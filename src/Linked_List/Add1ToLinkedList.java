package Linked_List;

public class Add1ToLinkedList extends Main{
    public static void main(String[] args) {
        Add1ToLinkedList obj = new Add1ToLinkedList();
        int[] arr = {5, 6, 2};
        Node root;
        root = obj.construct(arr);
        obj.display(root);
        root = obj.addOne(root);
        obj.display(root);
    }

    public Node addOne(Node head) {

        int carry = helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public int helper(Node head) {
        Node temp = head;
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        temp.value = temp.value + carry;
        if (temp.value < 10) {
            return 0;
        }
        temp.value = 0;
        return 1;
    }
}
