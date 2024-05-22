package Linked_List;

import java.util.LinkedList;

public class ReverseLinkedList extends Main {
    public static void main(String[] args) {
        int [] arr = {1, 3, 2, 5};
        ReverseLinkedList obj = new ReverseLinkedList();
        Node root;
        root = obj.construct(arr);
        obj.display(root);
        root = obj.reverseList(root);
        obj.display(root);
    }

    public Node reverseList(Node root) {

//        Recursive Approach :-

        if ((root == null) || (root.next == null)) {
            return root;
        }
        Node newRoot = reverseList(root.next);
        Node front = root.next;
        front.next = root;
        root.next = null;
        return newRoot;

//        Iterative Approach :-

//        Node prev = null;
//        Node temp = root;
//        Node front;
//        while (temp != null) {
//            front = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = front;
//        }
//        return prev;
    }
}
