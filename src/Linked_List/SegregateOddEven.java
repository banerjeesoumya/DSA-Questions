package Linked_List;

public class SegregateOddEven extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        SegregateOddEven ob = new SegregateOddEven();
        Node root;
        root = ob.construct(arr);
        root = ob.oddEvenList(root);
        ob.display(root);
    }

    public Node oddEvenList(Node root) {
        if ((root == null) || (root.next == null)){
            return root;
        }
        Node odd = root;
        Node evenHead = root.next;
        Node even = evenHead;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return root;
    }
}
