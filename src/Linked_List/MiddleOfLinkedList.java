package Linked_List;

public class MiddleOfLinkedList extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        MiddleOfLinkedList obj = new MiddleOfLinkedList();
        Node root;
        root = obj.construct(arr);
        System.out.println(middleNode(root).value);
        obj.display(root);
    }

    public static Node middleNode(Node root) {
//        Optimal Approach [Time Complexity - O(n/2), Space Complexity - O(1)]
        Node slow = root;
        Node fast = root;
        while (fast != null && fast.next != null) {
            {
                fast = fast.next.next;;
                slow = slow.next;
            }
        }
        return slow;
//        Brute Force Approach [Time Complexity - O(n + n/2), Space Complexity - O(1)]
//        Node temp = root;
//        int c = 0;
//        while (temp != null) {
//            c ++;
//            temp = temp.next;
//        }
//        int mid = (c / 2) + 1;
//        c = 1;
//        temp = root;
//        while (c != mid) {
//            c ++;
//            temp = temp.next;
//        }
//        return temp;
    }
}
