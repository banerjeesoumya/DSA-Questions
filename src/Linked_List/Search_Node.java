package Linked_List;

public class Search_Node extends Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Search_Node ob = new Search_Node();
        Node root = ob.construct(arr);
        System.out.println(ob.searchKey(root, 3));
        ob.display(root);
    }

    public boolean searchKey(Node head, int key) {
        if (head.value == key) {
            return true;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.value == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
