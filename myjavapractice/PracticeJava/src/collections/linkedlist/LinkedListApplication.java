package collections.linkedlist;
import java.util.*;



public class LinkedListApplication{

    public static void main(String[] args) {

        // ✅ 1. Create a LinkedList
        LinkedList<String> fruits = new LinkedList<>();
        System.out.println("Initial LinkedList: " + fruits);

        // ✅ 2. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        System.out.println("After adding elements: " + fruits);

        // Add element at the first position
        fruits.addFirst("Pineapple");
        // Add element at the last position
        fruits.addLast("Grapes");
        System.out.println("After addFirst and addLast: " + fruits);

        // ✅ 3. Remove elements
        fruits.remove("Mango");          // remove by value
        fruits.removeFirst();            // remove first element
        fruits.removeLast();             // remove last element
        System.out.println("After removals: " + fruits);

        // ✅ 4. Iterate over the LinkedList

        // 4a. Using for-each loop
        System.out.print("Iterating using for-each loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 4b. Using iterator
        System.out.print("Iterating using iterator: ");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 4c. Using forEach lambda (Java 8+)
        System.out.print("Iterating using forEach lambda: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();

        // ✅ 5. Other useful operations
        System.out.println("First element: " + fruits.getFirst());
        System.out.println("Last element: " + fruits.getLast());
        System.out.println("Size of LinkedList: " + fruits.size());

        // Check if list contains an element
        System.out.println("Contains 'Banana'? " + fruits.contains("Banana"));
    }
}