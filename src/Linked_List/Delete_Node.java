/*
There is a singly-linked list 'head' and we want to delete a node 'node' in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node 'node'
is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory.
 */
package Linked_List;

public class Delete_Node extends Main{
    public static void main(String[] args) {
        Delete_Node ob = new Delete_Node();
        int[] arr = {4, 5, 1, 9};
        Node root;
        root = ob.construct(arr);
        ob.deleteNode(root.next);
        ob.display(root);

    }
     public void deleteNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
     }
}
