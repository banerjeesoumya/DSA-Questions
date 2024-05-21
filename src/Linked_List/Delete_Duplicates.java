package Linked_List;

public class Delete_Duplicates extends Main{
    public static void main(String[] args) {
        Delete_Duplicates ob = new Delete_Duplicates();
        int[] arr = {1, 1, 1};
        Node root = ob.construct(arr);
        root = ob.deleteDuplicates(root);
        ob.display(root);
    }

    public Node deleteDuplicates(Node head) {
        Node temp = head;
        while ((temp != null) && (temp.next != null)) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
