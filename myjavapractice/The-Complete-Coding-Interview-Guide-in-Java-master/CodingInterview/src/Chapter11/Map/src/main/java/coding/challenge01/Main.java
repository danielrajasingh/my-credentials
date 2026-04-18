package Chapter11.Map.src.main.java.coding.challenge01;

public class Main {
    /*
    ✅ 1. What is the Question?

    You are asked to:

    👉 Implement a basic Map (key-value data structure) from scratch with 3 operations:
    put(K key, V value) → Insert or update value
    get(K key) → Retrieve value using key
    remove(K key) → Delete entry using key
    👉 Constraints:
    Keys must be unique
    Use array-based storage (no built-in Map like HashMap)

    🔍 2. Clear Analysis
    Think of it like this:
        A Map = collection of key-value pairs
    Since Java arrays store single objects → we need a wrapper:
    ✔ Entry (key, value)
    Core Design:
        Create Entry<K, V> class
        Store entries in an array
        Track current size
    Handle:
    Duplicate keys → update value
    Capacity full → resize array
    Removal → shift elements
    💡 3. Solution Idea

    We implement using:

    Components:
        Entry[] entries → array storage
        size → current number of elements
        DEFAULT_CAPACITY = 16
    Operations:
    ✔ put()
        If key exists → update value
        Else → add new entry
        If full → double array size
    ✔ get()
        Linear search
        Return value if found
        Else return null
    ✔ remove()
        Find key
        Remove element
        Shift remaining elements left
        Set last element to null (avoid memory leak)


    ⚙️ 4. Solution Implementation (Simplified)
    class MyMap<K, V> {

        private static final int DEFAULT_CAPACITY = 16;

        private static class Entry<K, V> {
            K key;
            V value;

            Entry(K k, V v) {
                key = k;
                value = v;
            }
        }

        private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];
        private int size = 0;

        public void put(K key, V value) {
            for (int i = 0; i < size; i++) {
                if (entries[i].key.equals(key)) {
                    entries[i].value = value;
                    return;
                }
            }

            if (size == entries.length) resize();

            entries[size++] = new Entry<>(key, value);
        }

        private void resize() {
            Entry<K, V>[] newArr = new Entry[entries.length * 2];
            System.arraycopy(entries, 0, newArr, 0, entries.length);
            entries = newArr;
        }

        public V get(K key) {
            for (int i = 0; i < size; i++) {
                if (entries[i].key.equals(key)) {
                    return entries[i].value;
                }
            }
            return null;
        }

        public void remove(K key) {
            for (int i = 0; i < size; i++) {
                if (entries[i].key.equals(key)) {

                    for (int j = i; j < size - 1; j++) {
                        entries[j] = entries[j + 1];
                    }

                    entries[size - 1] = null;
                    size--;
                    return;
                }
            }
        }
    }
    🧠 5. One-Line Memory Trick

    👉 “Map = Array + Entry + Linear Search + Resize + Shift on Delete”

    🎯 Bonus (Interview Insight)

    If interviewer asks:

    👉 “Is this optimal?”

    You should say:

    ❌ This is O(n) for all operations
    ✅ Real maps (like HashMap) use hashing + buckets → O(1) average

    If you want, I can convert this into:
    ✅
    Flashcards
    ✅
    Interview Q&A
    ✅
    Visual diagram
    ✅
    Step-by-step dry run

    Just tell me 👍
     */





    /*
    Here’s your interview-style structured answer for Coding Challenge 2 👇

✅ 1. What is the Question?

You already have a basic Map implementation.

👉 Now extend it by adding:

keySet() → return all keys as a Set
values() → return all values as a Collection
🔍 2. Clear Analysis

We already have:

Array of Entry<K, V>
Each entry contains key + value

Now we need:

🔹 keySet()
Keys must be unique
Best structure → Set
Loop through entries → extract keys → add to set
🔹 values()
Values can have duplicates
Best structure → List
Loop through entries → extract values → add to list


💡 3. Solution Idea
👉 Traverse the internal array (entries[]) and:
For keySet():
Create HashSet
Add each key
For values():
Create ArrayList
Add each value
⚙️ 4. Solution Implementation
import java.util.*;

class MyMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];
    private int size = 0;

    // Existing methods (put, get, remove)...

    // ✅ Return all keys
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add(entries[i].key);
        }

        return set;
    }

    // ✅ Return all values
    public Collection<V> values() {
        List<V> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(entries[i].value);
        }

        return list;
    }
}
🧠 5. One-Line Memory Trick

👉 “Keys → Set (unique), Values → List (duplicates allowed)”

🎯 Bonus (Interview Insight)

If interviewer pushes deeper:

👉 Current complexity:

keySet() → O(n)
values() → O(n)

👉 In real-world (HashMap):

These may be cached views, not rebuilt every time
More optimized using internal structures (buckets, hashing)

If you want next level 🚀
I can give:

Dry run example
Diagram (array → set/list flow)
Combined Map implementation (all methods together)
Interview tricky follow-up questions

Just tell me 👍




🧪 Dry Run Example
Step 0: Initial State
entries = [ ]
size = 0
🔹 Step 1: Insert Data (put)
put("A", 10)
put("B", 20)
put("C", 10)
put("D", 30)
Internal Array:
Index   Key   Value
0       A     10
1       B     20
2       C     10   ← duplicate value allowed
3       D     30

size = 4
🔹 Step 2: Call keySet()
Set<K> keys = keySet();
Execution:
Create empty HashSet
Loop through entries:
Iteration	Key	Set Content
i = 0	A	{A}
i = 1	B	{A, B}
i = 2	C	{A, B, C}
i = 3	D	{A, B, C, D}
✅ Output:
[A, B, C, D]

👉 No duplicates because Set enforces uniqueness

🔹 Step 3: Call values()
Collection<V> values = values();
Execution:
Create empty ArrayList
Loop through entries:
Iteration	Value	List Content
i = 0	10	[10]
i = 1	20	[10, 20]
i = 2	10	[10, 20, 10]
i = 3	30	[10, 20, 10, 30]
✅ Output:
[10, 20, 10, 30]

👉 Duplicate 10 is preserved because List allows duplicates

🔹 Step 4: After Removal
remove("B")
Internal Array After Shift:
Index   Key   Value
0       A     10
1       C     10
2       D     30

size = 3
Call again:
keySet()
[A, C, D]
values()
[10, 10, 30]
🧠 Final Understanding
keySet() → collects unique keys
values() → collects all values (duplicates allowed)
Both → linear scan (O(n))
⚡ One-Line Recall

👉 “Scan array → keys go to Set, values go to List”



Here’s a simple visual diagram to help you “see” how keySet() and values() work 👇

📊 1. Internal Map Structure (Array of Entries)
        entries[]
   ┌───────────────────────┐
0  │  (A → 10)             │
1  │  (B → 20)             │
2  │  (C → 10)             │
3  │  (D → 30)             │
   └───────────────────────┘
            size = 4
🔹 2. keySet() Flow (Keys → Set)
Step 1: Create empty Set
        keys = { }

Step 2: Traverse entries[]

(A → 10)  → add A → {A}
(B → 20)  → add B → {A, B}
(C → 10)  → add C → {A, B, C}
(D → 30)  → add D → {A, B, C, D}
✅ Result:
Set (Unique Keys)
┌────────────────┐
│  A, B, C, D    │
└────────────────┘

👉 No duplicates allowed

🔹 3. values() Flow (Values → List)
Step 1: Create empty List
        values = [ ]

Step 2: Traverse entries[]

(A → 10)  → add 10 → [10]
(B → 20)  → add 20 → [10, 20]
(C → 10)  → add 10 → [10, 20, 10]
(D → 30)  → add 30 → [10, 20, 10, 30]
✅ Result:
List (Values)
┌────────────────────────┐
│  10, 20, 10, 30        │
└────────────────────────┘

👉 Duplicates allowed

🔄 4. After remove("B")
Before:
(A → 10), (B → 20), (C → 10), (D → 30)

After shifting:
(A → 10), (C → 10), (D → 30)
Updated Outputs:
keySet()  → {A, C, D}
values()  → [10, 10, 30]
🧠 Mental Visualization (Super Important)
          entries[]
        ┌─────────────┐
        │ A → 10      │
        │ B → 20      │
        │ C → 10      │
        │ D → 30      │
        └─────────────┘
             ↓ ↓
        ┌──────────┐     ┌───────────────┐
        │ keySet() │     │ values()      │
        └──────────┘     └───────────────┘
             ↓                  ↓
        {A,B,C,D}        [10,20,10,30]
        (Set)              (List)
⚡ One-Line Visual Memory Trick

👉 “Same array → split into Set (keys) and List (values)”


        Key
         ↓
     hash(key)
         ↓
   index = hash % n
         ↓
   Bucket[index]
         ↓
   ┌──────────────┐
   │ Linked List  │ OR Tree
   └──────────────┘
         ↓
   Find key → return value
     */
    public static void main(String[] args) {

        MyMap<String, Integer> map = new MyMap<>();
        
        map.put("Alex", 1);
        map.put("Tomy", 2);
        map.put("Anna", 3); 
        
        System.out.println("Alex value is: " + map.get("Alex"));
        
        map.remove("Alex");

        System.out.println(map);
    }

}
