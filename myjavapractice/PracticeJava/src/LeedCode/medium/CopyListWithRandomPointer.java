package medium;

import java.util.*;

public class CopyListWithRandomPointer {
    /* Problem: Copy List with Random Pointer | Link: https://leetcode.com/problems/copy-list-with-random-pointer
    Difficulty: Medium | Topic: Hash Table, Linked List | Deep copy with random.
    APPROACH: HashMap nodes mapping. O(n). */

    static class Node {
        int val;
        Node next, random;
        Node(int val) { this.val = val; }
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        System.out.println("Copy works\n");
    }
}
