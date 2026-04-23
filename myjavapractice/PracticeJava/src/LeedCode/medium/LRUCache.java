package medium;

import java.util.*;

public class LRUCache {
    /*
    ========================================
    Problem: LRU Cache
    Link: https://leetcode.com/problems/lru-cache
    Difficulty: Medium
    Topic: Hash Table, Linked List, Design, Doubly-Linked List
    ========================================
    
    PROBLEM EXPLANATION:
    Design a data structure for LRU (Least Recently Used) Cache with:
    - get(key): Get value by key, update it as recently used
    - put(key, value): Add/update key-value pair, evict LRU if capacity exceeded
    
    Both operations must run in O(1) time.
    
    Example: LRUCache(2)
    put(1,1): {1=1}
    put(2,2): {1=1, 2=2}
    get(1): returns 1, {2=2, 1=1} (1 becomes most recent)
    put(3,3): evicts key 2, {1=1, 3=3}
    
    KEY OBSERVATIONS:
    - Need HashMap for O(1) key lookup
    - Need Doubly-LinkedList to track order (MRU at end, LRU at head)
    - get: access key, move to end (most recent)
    - put: add key, move to end; if capacity exceeded, remove head
    - Both operations O(1)
    
    APPROACH:
    1. Use HashMap<key, Node> for fast access
    2. Use Doubly-LinkedList to maintain order
    3. Keep dummy head and tail for easier manipulation
    4. get(key): find in map, move to end, return value
    5. put(key, value): 
       - If key exists, update value, move to end
       - If key doesn't exist, create node, add to end
       - If capacity exceeded, remove head.next (oldest)
    
    TIME COMPLEXITY: O(1) - all operations (get, put, move)
    SPACE COMPLEXITY: O(capacity) - map and list size
    
    DRY RUN:
    LRUCache(2)
    put(1,1): map={1:node1}, list: 1
    put(2,2): map={1:node1, 2:node2}, list: 1 ↔ 2
    get(1): move 1 to end, list: 2 ↔ 1, return 1
    put(3,3): add 3, capacity full, remove LRU(2)
             map={1:node1, 3:node3}, list: 1 ↔ 3
    Result: ✓
    
    MEMORY TRICK:
    "HashMap + DoublyLinkedList: fast lookup + order tracking"
    
    VISUALIZATION:
    Doubly-LinkedList:
    head ↔ [1] ↔ [2] ↔ tail (2 is MRU)
    
    After get(1):
    head ↔ [2] ↔ [1] ↔ tail (1 is MRU)
    
    After put(3, when full):
    head ↔ [2] ↔ [1] ↔ tail  → remove 2
    head ↔ [1] ↔ [3] ↔ tail (3 is new)
    */

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // dummy head
        this.tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        removeNode(node);
        addToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToEnd(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToEnd(newNode);

            if (cache.size() > capacity) {
                Node lru = head.next;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public static void main(String[] args) {
        // Test case 1
        LRUCache cache = new LRUCache(2);
        System.out.println("LRUCache(2)");
        cache.put(1, 1);
        System.out.println("put(1, 1)");
        cache.put(2, 2);
        System.out.println("put(2, 2)");
        System.out.println("get(1): " + cache.get(1) + " (expected: 1)");
        cache.put(3, 3);
        System.out.println("put(3, 3)");
        System.out.println("get(2): " + cache.get(2) + " (expected: -1, evicted)\n");

        // Test case 2
        LRUCache cache2 = new LRUCache(1);
        System.out.println("LRUCache(1)");
        cache2.put(2, 1);
        System.out.println("put(2, 1)");
        System.out.println("get(2): " + cache2.get(2) + " (expected: 1)");
        cache2.put(3, 2);
        System.out.println("put(3, 2)");
        System.out.println("get(2): " + cache2.get(2) + " (expected: -1, evicted)\n");
    }
}
