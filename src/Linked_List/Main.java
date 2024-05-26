// 👇👇 To Main a Linked List 👇👇
package Linked_List;

import Linked_List.Node;

public class Main {
    public static void main(String[] args) {
        Main ob = new Main();
        int[] arr = {1, 2, 3, 4 , 5};
        Node root = ob.construct(arr);
//        root = ob.inserAtBeginning(root, 0);
        ob.display(root);
    }
    public Node construct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

//
//    public Node inserAtBeginning(Node head, int val) {
//        Node node = new Node(val);
//        node.next = head;
//        head = node;
//        return head;
//    }
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " => ");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
