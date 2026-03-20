package collections.set;
import java.util.*;
import java.util.stream.Collectors;

public class SetApplication {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30, 40, 50));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 40, 50, 60));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(40, 50, 70));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        // ✅ Approach 1: Using retainAll()
        Set<Integer> intersection1 = new HashSet<>(set1); // copy
        intersection1.retainAll(set2);
        intersection1.retainAll(set3);
        System.out.println("Intersection using retainAll(): " + intersection1);

        // ✅ Approach 2: Using Streams (filter)
        Set<Integer> intersection2 = set1.stream()
                .filter(set2::contains)
                .filter(set3::contains)
                .collect(Collectors.toSet());
        System.out.println("Intersection using Streams: " + intersection2);

        // ✅ Approach 3: Generic approach for multiple sets
        List<Set<Integer>> listOfSets = Arrays.asList(set1, set2, set3);

        Set<Integer> intersection3 = new HashSet<>(listOfSets.get(0));
        for (int i = 1; i < listOfSets.size(); i++) {
            intersection3.retainAll(listOfSets.get(i));
        }
        System.out.println("Intersection using loop (multiple sets): " + intersection3);
    }
}
