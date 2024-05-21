// 👇👇 Given a singly linked list. The task is to find the length of the linked list,
// where length is defined as the number of nodes in the linked list.
package Linked_List;

public class Count_Nodes extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Count_Nodes ob = new Count_Nodes();
        Node root;
        root = ob.construct(arr);
        System.out.println(ob.getCount(root));
        ob.display(root);
    }
    public int getCount(Node head) {
        int c = 0;
        Node temp = head;
        while (temp != null) {
            c ++;
            temp = temp.next;
        }
        return c;
    }
}
