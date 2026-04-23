package Chapter11.LRUCache.src.main.java.coding.challenge17;
 
public class Main {
/*
Great — this is one of the most important interview patterns (LRU Cache). I’ll break it in a way that makes it click immediately.
Problem: Write a snippet of code to implement a fixed-size LRU cache. LRU cache stands
for Least Recently Used Cache. This means that, when the cache is full, adding a new entry
will instruct the cache to automatically evict the least recently used entry.

🧩 1. What is the Question?

👉 You must design an LRU Cache (Least Recently Used Cache)

It should support:

1. get(key)
return value if exists
mark it as recently used
2. put(key, value)
insert/update value
if cache is full → remove least recently used item
🎯 Example:
Capacity = 2

put(1,10)
put(2,20)
get(1) → 10   (1 becomes most recent)

put(3,30) → evicts key 2 (least used)

Cache now:
1 → 3
🔍 2. Clear Analysis (WHY this design)
🧠 Problem Requirements:

We need:

Operation	Requirement
get	O(1)
put	O(1)
eviction	O(1)
❌ Why normal structures fail:
Array → slow deletion
LinkedList → slow search
HashMap → fast lookup but no order tracking
💡 Final Idea (Hybrid Solution):

We combine:

1. HashMap

👉 fast lookup (O(1))

2. Doubly Linked List

👉 fast insert/delete + order tracking

🧠 Key Insight:
HashMap → gives node instantly
Doubly Linked List → tracks usage order
⚙️ 3. Solution Idea

We maintain:

📌 Doubly Linked List order:
Head → Most Recently Used
Tail → Least Recently Used
Operations:
🔹 get(key)
find node in map
move it to head
🔹 put(key, value)
if exists → update + move to head
if new:
if full → remove tail
add new node at head
💻 4. Solution Implementation (Simplified)
class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity = 5;

    public int get(int key) {

        Node node = map.get(key);

        if (node == null) return -1;

        remove(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            remove(node);
            addToHead(node);
        } else {

            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) head.prev = node;

        head = node;

        if (tail == null) tail = head;
    }

    private void remove(Node node) {

        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }
}
🧠 5. One-Line Memory Trick

👉 “HashMap for lookup + DLL for recent order.”

🧪 6. Dry Run Example
Capacity = 2
Step 1:
put(1,10)

Cache:

1
Step 2:
put(2,20)

Cache:

2 → 1
Step 3:
get(1)

Now 1 becomes most recent:

1 → 2
Step 4:
put(3,30)

👉 Evict least recent (2)

3 → 1
🎨 7. Mental Visualization

Think like a browser history + VIP queue

📌 Head = recently used
HEAD → [MOST RECENT]
        [USED]
        [USED]
TAIL → [LEAST RECENT]
When you access:

👉 Move item to top

Used item jumps to HEAD
When full:

👉 Remove bottom (TAIL)

TAIL gets removed
⚡ Key Insight
Structure	Role
HashMap	instant access
Doubly Linked List	usage order
Head	most recent
Tail	least recent
🚨 Common Mistakes

❌ Using only HashMap
❌ Not updating DLL order on get
❌ Forgetting to remove tail when full

🧠 Final Understanding

👉 LRU Cache =

Fast lookup + smart ordering of usage

If you want next step, I can show:

🎬
animation of cache movements step-by-step
🧱
memory diagram (how nodes move in heap)
🔥
interview story explanation (how to explain in 2 minutes)

Just tell 👍
 */
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();
        
        cache.putEntry(1, 10);
        cache.putEntry(2, 20);
        cache.putEntry(3, 30);
        cache.putEntry(4, 40);
        cache.putEntry(5, 50);
        cache.putEntry(6, 60);
        cache.putEntry(7, 70);
        
        cache.print();
        
        System.out.println("\nGet key 4: " + cache.getEntry(4));
        
        cache.print();
        
        cache.putEntry(8, 80);
        cache.putEntry(9, 90);
        
        cache.print();
        
        System.out.println("\nGet key 6: " + cache.getEntry(6));        
        cache.print();
        
        System.out.println("\nGet key 2 (-1 means data not found): " + cache.getEntry(2));                
        cache.print();               
        
        System.out.println("\nGet key 6: " + cache.getEntry(6));                
        cache.print();               
        
        System.out.println("\nGet key 8: " + cache.getEntry(8));                
        cache.print();               
        
        cache.putEntry(10, 100);
        cache.print();               
    }
    

}
