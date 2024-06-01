package Linked_List;

public class AddTwoNumbers extends Main{
    public static void main(String[] args) {
        int[] arr1 = {9,9,9,9,9,9,9};
        int[] arr2 = {9, 9, 9, 9};
        AddTwoNumbers ob = new AddTwoNumbers();
        Node head1, head2;
        head1 = ob.construct(arr1);
        head2 = ob.construct(arr2);
        ob.display(head1);
        ob.display(head2);
        Node sumHead = ob.addTwoNumbers(head1, head2);
        ob.display(sumHead);
    }

    public Node addTwoNumbers(Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        int carry = 0;
        Node temp1 = head1, temp2 = head2, curr = dummyHead;
        while(temp1 != null || temp2 != null) {
            int sum = carry;
            if(temp1 != null) {
                sum = temp1.value + sum;
            }
            if(temp2 != null) {
                sum = temp2.value + sum;
            }
            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if(temp1 != null) {
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                temp2 = temp2.next;
            }
        }
        if (carry == 1) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return dummyHead.next;
    }
}
