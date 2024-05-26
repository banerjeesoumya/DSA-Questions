package Linked_List;

public class SortList extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 2, 0, 2, 2};
        SortList sl = new SortList();
        Node root;
        root = sl.construct(arr);
        sl.display(root);
        Node newRoot = sl.sortList(root);
        sl.display(newRoot);
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = middleNode(head);
        Node leftHead = head, rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return merge(leftHead, rightHead);
    }

    public Node middleNode(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp1 = l1, temp2 = l2, temp3 = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                temp3.next = temp1;
                temp1 = temp1.next;
            } else {
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        while (temp1 != null) {
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }
        while (temp2 != null) {
            temp3.next = temp2;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }
        return dummy.next;
    }
}
