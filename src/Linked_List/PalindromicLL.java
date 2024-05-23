package Linked_List;

public class PalindromicLL extends Main{
    public static void main(String[] args) {
        PalindromicLL p = new PalindromicLL();
        int[] arr = {1, 2};
        Node root;
        root = p.construct(arr);
        if (isPalindrome(root)){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    public static boolean isPalindrome(Node head){
        if ((head == null) || (head.next == null)) {
            return true;
        }
//        Step - 1 :- Divide the linked list into two halves, by finding the middle
        Node fast = head, slow = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        Step - 2 :- Reverse from the second half
        Node newHead = reverse(slow.next);
        Node first = head, second = newHead;
        while (second != null) {
            if (first.value != second.value) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    public static Node reverse(Node head){
        if ((head == null) || (head.next == null)) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node front  = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
