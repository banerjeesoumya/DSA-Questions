package Linked_List;

public class LenghtOfLoop {
    public static void main(String[] args) {
        Node head = new Node(25);
        Node second = new Node(14);
        Node third = new Node(19);
        Node fourth = new Node(33);
        Node fifth = new Node(10);
        Node sixth = new Node(21);
        Node seventh = new Node(39);
        Node eighth = new Node(90);
        Node ninth = new Node(58);
        Node tenth = new Node(45);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        // Create a loop
        tenth.next = fourth;

        System.out.println(lengthOfLoop(head));
    }

    public static int lengthOfLoop(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return findLength(slow, fast);
            }
        }
        return 0;
    }

    public static int findLength(Node slow, Node fast) {
        int count = 1;
        fast = fast.next;
        while (fast != slow){
            fast = fast.next;
            count ++;
        }
        return count;
    }
}
