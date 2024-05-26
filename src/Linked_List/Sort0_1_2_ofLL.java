package Linked_List;

public class Sort0_1_2_ofLL extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 2, 1};
        Sort0_1_2_ofLL sol = new Sort0_1_2_ofLL();
        Node root;
        root = sol.construct(arr);
        sol.display(root);
        Node newRoot = sol.segregate(root);
        sol.display(newRoot);
    }

    public Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node dummyZero = zeroHead, dummyOne = oneHead, dummyTwo = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.value == 0) {
                dummyZero.next = temp;
                dummyZero = dummyZero.next;
            } else if (temp.value == 1) {
                dummyOne.next = temp;
                dummyOne = dummyOne.next;
            } else {
                dummyTwo.next = temp;
                dummyTwo = dummyTwo.next;
            }
            temp = temp.next;
        }
        dummyZero.next = (oneHead.next != null) ? (oneHead.next) : (twoHead.next);
        dummyOne.next = twoHead.next;
        dummyTwo.next = null;

        return zeroHead.next;
    }
}
