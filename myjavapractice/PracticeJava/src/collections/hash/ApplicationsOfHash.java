package collections.hash;
import java.util.*;
import java.util.stream.Collectors;

/*
🔥 Hash Collections Interview Tips

✅ HashSet:
   - No duplicates
   - No order
   - Uses hashCode() + equals()

✅ HashMap:
   - Key-value pairs
   - Keys are unique, values can duplicate
   - Allows one null key, multiple null values

✅ LinkedHashSet / LinkedHashMap:
   - Maintains insertion order

✅ Time Complexity:
   - add(), remove(), contains() → O(1) average

⚠️ Important:
   - Always override equals() & hashCode() for custom objects
   - Otherwise duplicate detection will fail

✅ Difference:
   HashSet → only values
   HashMap → key-value
*/
public class ApplicationsOfHash {
    public static void main(String[] args) {
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  1 . Hash set                               🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // duplicate ignored

        System.out.println("HashSet: " + set);

        // Check element
        System.out.println("Contains Apple? " + set.contains("Apple"));

        // Remove element
        set.remove("Banana");

        System.out.println("After removal: " + set);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  2 . Hash map                               🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");

        System.out.println("HashMap: " + map);

        // Access value
        System.out.println("Key 2: " + map.get(2));

        // Check key
        System.out.println("Contains key 3? " + map.containsKey(3));

        // Remove
        map.remove(1);

        System.out.println("After removal: " + map);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  3 . LinkedHashSet Example                           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Mango");

        System.out.println("LinkedHashSet (ordered): " + linkedHashSet);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  4 . LinkedHashSet Example                           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "Apple");
        linkedHashMap.put(2, "Banana");
        linkedHashMap.put(3, "Mango");

        System.out.println("LinkedHashMap (ordered): " + linkedHashMap);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  5 . mappings of country names to their capitals                           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // Create HashMap
        Map<String, String> countryCapitalMap = new HashMap<>();

        // Add country-capital mappings
        countryCapitalMap.put("India", "New Delhi");
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Germany", "Berlin");
        countryCapitalMap.put("Japan", "Tokyo");

        // Print the map
        System.out.println("Country-Capital Map: " + countryCapitalMap);

        // Get a specific capital
        System.out.println("Capital of Canada: " + countryCapitalMap.get("Canada"));

        // Iterate through the map
        System.out.println("\nAll entries:");
        for (Map.Entry<String, String> entry : countryCapitalMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  6 . common elements between two HashSet           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30, 40, 50));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(30, 40, 50, 60, 70));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        // ✅ Approach 1: Using retainAll()
        HashSet<Integer> intersection1 = new HashSet<>(set1); // copy
        intersection1.retainAll(set2);
        System.out.println("Common elements (retainAll): " + intersection1);

        // ✅ Approach 2: Using Streams (filter)
        Set<Integer> intersection2 = set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
        System.out.println("Common elements (Streams): " + intersection2);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  7 . HashSet is a subset of another HashSet.          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        HashSet<Integer> mainSet = new HashSet<>(Arrays.asList(10, 20, 30, 40, 50));
        HashSet<Integer> subSet = new HashSet<>(Arrays.asList(20, 30));

        System.out.println("Main Set: " + mainSet);
        System.out.println("Subset: " + subSet);

        // ✅ Check subset using containsAll()
        if (mainSet.containsAll(subSet)) {
            System.out.println("subSet is a subset of mainSet");
        } else {
            System.out.println("subSet is NOT a subset of mainSet");
        }

        // ❌ Example where it's not a subset
        HashSet<Integer> subSet2 = new HashSet<>(Arrays.asList(20, 60));

        if (mainSet.containsAll(subSet2)) {
            System.out.println("subSet2 is a subset of mainSet");
        } else {
            System.out.println("subSet2 is NOT a subset of mainSet");
        }

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  8 . Find the frequency of elements in a list using HashMap.          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // Create a HashMap to store frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Iterate through the list
        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                // If the item is already in the map, increment its count
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                // If the item is not in the map, add it with count 1
                frequencyMap.put(item, 1);
            }
        }

        // Print the frequencies
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  9 . Check if two arrays/lists are anagrams using HashMap.          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        List<String> fruitsList1 = new ArrayList<>(Arrays.asList("apple", "banana", "orange", "apple"));
        List<String> fruitsList2 = new ArrayList<>(Arrays.asList("banana", "apple", "apple", "orange"));

        boolean result = areAnagrams(fruitsList1, fruitsList2);
        System.out.println("Are the two fruit lists anagrams? " + result);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  10 . Counting the occurrences of words in a string using a HashMap          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//



        String text = "apple banana apple orange banana apple";

        // Call the function to get word frequencies
        Map<String, Integer> wordCount = countWordOccurrences(text);

        // Print the word frequencies
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  11 . Counting the occurrences of words in a string using a HashMap          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        List<String> fruits = new ArrayList<>(Arrays.asList(
                "apple", "banana", "orange", "apple", "banana", "grape"
        ));

        // Use a HashMap to count frequencies
        Map<String, Integer> frequencyMap3 = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        for (String fruit : fruits) {
            frequencyMap3.put(fruit, frequencyMap3.getOrDefault(fruit, 0) + 1);
        }

        // Identify duplicates
        // Iterate through each entry (key-value pair) in the frequency map
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            // Check if the count of this element is more than 1
            if (entry.getValue() > 1) {
                // If yes, add the element (key) to the duplicates set
                duplicates.add(entry.getKey());
            }
        }

        // Print duplicate elements
        System.out.println("Duplicate elements: " + duplicates);



        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  12 . Counting the occurrences of words in a string using a HashMap          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // Example array
        String[] fruits7 = {"apple", "banana", "orange", "apple", "banana", "grape"};

        // HashMap to store element counts
        Map<String, Integer> frequencyMap7 = new HashMap<>();
        Set<String> duplicates7 = new HashSet<>();

        // Count each element and find duplicates
        for (String fruit : fruits7) {
            // Increment count for this element
            int count = frequencyMap7.getOrDefault(fruit, 0) + 1;
            frequencyMap7.put(fruit, count);

            // If count > 1, it is a duplicate
            if (count > 1) {
                duplicates7.add(fruit);
            }
        }

        // Print duplicates
        System.out.println("Duplicate elements: " + duplicates);




        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  12 . merge two HashMaps          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // First HashMap
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 5);
        map1.put("banana", 3);
        map1.put("orange", 2);

        // Second HashMap
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 4);
        map2.put("orange", 3);
        map2.put("grape", 6);

        // Merge map2 into map1 (sum values if keys match)
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        // Print the merged map
        System.out.println("Merged HashMap: " + map1);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  13 . Hashmap Top K frequent elements logic but fully.          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        hashMapFindTopKFrequent();


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  14 . to find the first non-repeating character in a string efficiently         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        findNonRepeatedLettersInString();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  15 . to find the find Subset Check         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        findSubsetCheck();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  16 . all characters of one string are present in another string        🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        unionAndIntersectionOfTwoIntegerArray();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  1. Subset Check                               🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        subsetCheck();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  2. Union & Intersection of Arrays             🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        unionAndIntersection();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  3. Pair with Given Sum                        🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        pairWithGivenSum();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  4. Two Pair Sum                               🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        twoPairSum();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  5. Largest Subarray with 0 Sum                🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        largestSubarrayZeroSum();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  6. Distinct Elements in K-size Window         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        distinctElementsInWindow();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  7. Palindrome Substring Check                 🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        palindromeSubstringQueries();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  8. Missing Elements in Range                  🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        missingElementsInRange();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  9. All Subarrays with 0 Sum                   🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        allSubarraysWithZeroSum();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  10. Symmetric Pairs                          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        symmetricPairs();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  11. Duplicates within K Distance             🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        duplicatesWithinKDistance();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  12. Find Itinerary                           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        findItinerary();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  13. Largest Subarray Equal 0s & 1s           🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        largestSubarrayEqual01();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  14. Count Subarrays with XOR                 🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        countSubarraysWithXOR();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  15. Longest Consecutive Subsequence          🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        longestConsecutiveSubsequence();

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  16. Pair Sum Divisible by K                  🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        pairSumDivisibleByK();

        // 🔥 17. Smallest Range from K Lists
        smallestRangeFromKLists();

        // 🔥 18. Internal Working of HashMap
                internalWorkingOfHashMap();

        // 🔥 19. Separate Chaining
                separateChaining();

        // 🔥 20. Hash Table with Chaining
                hashTableWithChaining();

        // 🔥 21. Open Addressing
                openAddressing();

        countryToCapital();
        employeeIdToName();
        cityToPopulation();
        productToPrice();
        employeeIdToDepartment();

        hashSetExample();
        checkElementInHashSet();
        countryToCapitalMap();
        commonElementsBetweenLists();
        checkSubsetHashSet();
        removeDuplicatesMaintainOrder();
        preserveOrderAfterFiltering();
        findFirstRepeatingElement();



    }


    public static boolean areAnagrams(List<String> list1, List<String> list2) {
        // If sizes are different, they cannot be anagrams
        if (list1.size() != list2.size()) {
            return false;
        }

        // Count frequency of elements in list1
        Map<String, Integer> freqMap1 = new HashMap<>();
        for (String fruit : list1) {
            freqMap1.put(fruit, freqMap1.getOrDefault(fruit, 0) + 1);
        }

        // Count frequency of elements in list2
        Map<String, Integer> freqMap2 = new HashMap<>();
        for (String fruit : list2) {
            freqMap2.put(fruit, freqMap2.getOrDefault(fruit, 0) + 1);
        }

        System.out.println("===========================");
        System.out.println();
        // Compare the two frequency maps
        return freqMap1.equals(freqMap2);
    }


    public static Map<String, Integer> countWordOccurrences(String text) {
        // Create a HashMap to store word frequencies
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Split the string into words using space as delimiter
        String[] words = text.split("\\s+"); // handles multiple spaces

        // Count each word
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("===========================");
        System.out.println();
        return frequencyMap;
    }

    public static void hashMapFindTopKFrequent (){
            int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4,1};
            int k = 2;

            // Step 1: Count frequencies using HashMap
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                // Check if num is already in the map. short form
                // System.out.println(num+" "+freqMap.getOrDefault(num, 0));
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Use a min-heap (PriorityQueue) to keep top K elements
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
            for (int num : freqMap.keySet()) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll(); // remove the element with the smallest frequency
                }
            }

            // Step 3: Build the result list
            List<Integer> topK = new ArrayList<>();
            while (!heap.isEmpty()) {
                topK.add(heap.poll());
            }
            Collections.reverse(topK); // optional: highest frequency first

            // Step 4: Print result
            System.out.println("Top " + k + " frequent elements: " + topK);

        System.out.println("===========================");
        System.out.println();
        }

    public static void findNonRepeatedLettersInString(){
        /*
            ✅ Time Complexity: O(N)
            ✅ Space Complexity: O(N)
            Map → used only for counting
            String → used for order checking
            Prove:
            getOrDefault() → O(1)
            put() → O(1)
            T1 = N × O(1) = O(N)
            freqMap.get() → O(1)
            T2 = N × O(1) = O(N)
            T = T1 loop1 + T2 loop2
                    = O(N) + O(N)
                    = 2N Drop constants (Big-O rule): so T = O(N)
         */
            String str = "swiss";

            // Step 1: Count character frequencies
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char ch : str.toCharArray()) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            // Step 2: Find the first character with frequency 1
            char firstNonRepeating = '\0'; // default if none found
            for (char ch : str.toCharArray()) {
                if (freqMap.get(ch) == 1) {
                    firstNonRepeating = ch;
                    break;
                }
            }

            // Step 3: Print result
            if (firstNonRepeating != '\0') {
                System.out.println("First non-repeating character: " + firstNonRepeating);
            } else {
                System.out.println("No non-repeating character found.");
            }

        System.out.println("===========================");
        System.out.println();
        }


        public static void findSubsetCheck(){
        //all characters of one string are present in another string
            String str1 = "programming";
            String str2 = "gram";

            // Step 1: Build frequency map for str1
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str1.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Step 2: Check subset
            boolean isSubset = true;

            for (char ch : str2.toCharArray()) {
                if (!map.containsKey(ch) || map.get(ch) == 0) {
                    isSubset = false;
                    break;
                }
                map.put(ch, map.get(ch) - 1); // handle duplicates
            }

            // Step 3: Output
            if (isSubset) {
                System.out.println("str2 is a subset of str1");
            } else {
                System.out.println("str2 is NOT a subset of str1");
            }

            System.out.println("===========================");
            System.out.println();
        }

        public static void unionAndIntersectionOfTwoIntegerArray(){
            int[] arr1 = {1, 2, 2, 3, 4};
            int[] arr2 = {2, 2, 3, 5};

            // UNION
            Map<Integer, Integer> unionMap = new HashMap<>();

            for (int num : arr1) {
                unionMap.put(num, 1);
            }

            for (int num : arr2) {
                unionMap.put(num, 1);
            }

            System.out.println("Union: " + unionMap.keySet());

            // INTERSECTION
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : arr1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> intersection = new ArrayList<>();

            for (int num : arr2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    // contains of first array and frequency > 0
                    intersection.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }

            System.out.println("Intersection: " + intersection);

            System.out.println("===========================");
            System.out.println();
        }


    // 1. Subset Check
    public static void subsetCheck() {
        int[] a = {1,2,3,4,5};
        int[] b = {2,3,5};

        Map<Integer,Integer> map = new HashMap<>();
        for(int x: a) map.put(x, map.getOrDefault(x,0)+1);

        boolean flag = true;
        for(int x: b){
            if(!map.containsKey(x) || map.get(x)==0){
                flag = false;
                break;
            }
            map.put(x,map.get(x)-1);
        }

        System.out.println("Subset: " + flag);

        System.out.println("===========================");
        System.out.println();
    }

    // 2. Union & Intersection
    public static void unionAndIntersection() {
        int[] a = {1,2,2,3};
        int[] b = {2,3,4};

        Set<Integer> union = new HashSet<>();
        for(int x:a) union.add(x);
        for(int x:b) union.add(x);

        System.out.println("Union: " + union);

        Map<Integer,Integer> map = new HashMap<>();
        for(int x:a) map.put(x,map.getOrDefault(x,0)+1);

        List<Integer> inter = new ArrayList<>();
        for(int x:b){
            if(map.containsKey(x) && map.get(x)>0){
                inter.add(x);
                map.put(x,map.get(x)-1);
            }
        }
        System.out.println("Intersection: " + inter);

        System.out.println("===========================");
        System.out.println();
    }

    // 3. Pair with given sum
    public static void pairWithGivenSum() {
        int[] arr = {1,4,5,6};
        int sum = 10;

        Set<Integer> set = new HashSet<>();
        for(int x: arr){
            if(set.contains(sum-x)){
                System.out.println("Pair: " + x + "," + (sum-x));
                return;
            }
            set.add(x);
        }

        System.out.println("===========================");
        System.out.println();
    }

    // 4. Two Pair Sum (4 sum basic)
    public static void twoPairSum() {
        int[] arr = {1,2,3,4,5};
        int sum = 5;

        Map<Integer,String> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int s = arr[i]+arr[j];
                if(map.containsKey(sum-s)){
                    System.out.println("Pairs: " + map.get(sum-s) + " & ("+arr[i]+","+arr[j]+")");
                    return;
                }
                map.put(s,"("+arr[i]+","+arr[j]+")");
            }
        }

        System.out.println("===========================");
        System.out.println();
    }

    // 5. Largest subarray with 0 sum
    public static void largestSubarrayZeroSum() {
        int[] arr = {1,-1,3,-3,4};
        Map<Integer,Integer> map = new HashMap<>();

        int sum=0,max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0) max=i+1;
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            } else map.put(sum,i);
        }
        System.out.println("Largest Zero Sum Subarray: "+max);

        System.out.println("===========================");
        System.out.println();
    }

    // 6. Distinct elements in window
    public static void distinctElementsInWindow() {
        int[] arr = {1,2,1,3,4,2,3};
        int k=4;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<k;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        System.out.print(map.size()+" ");

        for(int i=k;i<arr.length;i++){
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k])==0) map.remove(arr[i-k]);

            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

            System.out.print(map.size()+" ");
        }
        System.out.println();

        System.out.println("===========================");
        System.out.println();
    }

    // 7. Palindrome Substring Query (simple)
    public static void palindromeSubstringQueries() {
        String s="abba";
        System.out.println("Is palindrome: "+ new StringBuilder(s).reverse().toString().equals(s));

        System.out.println("===========================");
        System.out.println();
    }

    // 8. Missing elements in range
    public static void missingElementsInRange() {
        int[] arr = {1,3,5};
        int n=5;

        Set<Integer> set = new HashSet<>();
        for(int x:arr) set.add(x);

        for(int i=1;i<=n;i++){
            if(!set.contains(i)) System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("===========================");
        System.out.println();
    }

    // 9. All subarrays with 0 sum
    public static void allSubarraysWithZeroSum() {
        int[] arr = {1,-1,2,-2};
        Map<Integer,List<Integer>> map = new HashMap<>();

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum==0) System.out.println("0 to "+i);

            if(map.containsKey(sum)){
                for(int start: map.get(sum))
                    System.out.println((start+1)+" to "+i);
            }

            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(i);
        }

        System.out.println("===========================");
        System.out.println();
    }

    // 10. Symmetric Pairs
    public static void symmetricPairs() {
        int[][] arr = {{1,2},{3,4},{2,1}};
        Map<Integer,Integer> map = new HashMap<>();

        for(int[] p: arr){
            if(map.containsKey(p[1]) && map.get(p[1])==p[0]){
                System.out.println("Symmetric: "+p[0]+","+p[1]);
            }
            map.put(p[0],p[1]);
        }

        System.out.println("===========================");
        System.out.println();
    }

    // 11. Duplicates within k distance
    public static void duplicatesWithinKDistance() {
        int[] arr = {1,2,3,1};
        int k=3;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]) && i-map.get(arr[i])<=k){
                System.out.println("Duplicate within k: "+arr[i]);
                return;
            }
            map.put(arr[i],i);
        }

        System.out.println("===========================");
        System.out.println();
    }

    // 12. Find Itinerary
    public static void findItinerary() {
        Map<String,String> map = new HashMap<>();
        map.put("A","B");
        map.put("B","C");

        Set<String> dest = new HashSet<>(map.values());

        String start="";
        for(String key: map.keySet()){
            if(!dest.contains(key)){
                start=key;
                break;
            }
        }

        while(map.containsKey(start)){
            System.out.print(start+" -> ");
            start=map.get(start);
        }
        System.out.println(start);

        System.out.println("===========================");
        System.out.println();
    }

    // 13. Largest subarray equal 0s & 1s
    public static void largestSubarrayEqual01() {
        int[] arr = {0,1,0,1,1};

        Map<Integer,Integer> map = new HashMap<>();
        int sum=0,max=0;

        for(int i=0;i<arr.length;i++){
            sum+= (arr[i]==0 ? -1 : 1);

            if(sum==0) max=i+1;

            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            } else map.put(sum,i);
        }
        System.out.println("Max 0-1 Subarray: "+max);

        System.out.println("===========================");
        System.out.println();
    }

    // 14. Count subarrays with XOR
    public static void countSubarraysWithXOR() {
        int[] arr = {4,2,2,6,4};
        int k=6;

        Map<Integer,Integer> map = new HashMap<>();
        int xor=0,count=0;

        for(int x:arr){
            xor ^= x;

            if(xor==k) count++;

            if(map.containsKey(xor^k))
                count+=map.get(xor^k);

            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        System.out.println("XOR count: "+count);

        System.out.println("===========================");
        System.out.println();
    }

    // 15. Longest consecutive subsequence
    public static void longestConsecutiveSubsequence() {
        int[] arr = {100,4,200,1,3,2};
        Set<Integer> set = new HashSet<>();
        for(int x:arr) set.add(x);

        int max=0;
        for(int x:set){
            if(!set.contains(x-1)){
                int curr=x,len=1;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                max=Math.max(max,len);
            }
        }
        System.out.println("Longest consecutive: "+max);

        System.out.println("===========================");
        System.out.println();
    }

    // 16. Pair sum divisible by K
    /* Note:
    Find pairs in an array such that:
    (a + b) % k == 0
    If:
        a % k = r
    Then we need:
        b % k = (k - r) % k

    idea:
    We store remainders in a HashMap and for each element check if its complementary remainder (k - rem) % k already exists.
     */
    public static void pairSumDivisibleByK() {
        System.out.println();
        System.out.println("===========================");
        System.out.println("pairSumDivisibleByK");
        System.out.println("===========================");
        System.out.println();
        int[] arr = {2,2,1,7,5,3};
        int k=4;

        Map<Integer,Integer> map = new HashMap<>();
        for(int x:arr){
            int rem = x%k;
            int need = (k-rem)%k;

            if(map.getOrDefault(need,0)>0){
                System.out.println("Pair: "+x);
                map.put(need,map.get(need)-1);
            } else {
                map.put(rem,map.getOrDefault(rem,0)+1);
            }
        }
        System.out.println("===========================");
        System.out.println();
    }

    public static void smallestRangeFromKLists() {

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        List<int[]> list = new ArrayList<>();

        // Flatten list with index info
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                list.add(new int[]{num, i});
            }
        }

        // Sort by value
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;
        int minRange = Integer.MAX_VALUE, start = 0, end = 0;

        for (int right = 0; right < list.size(); right++) {
            int[] r = list.get(right);

            map.put(r[1], map.getOrDefault(r[1], 0) + 1);
            if (map.get(r[1]) == 1) count++;

            while (count == nums.size()) {
                int[] l = list.get(left);

                if (list.get(right)[0] - list.get(left)[0] < minRange) {
                    minRange = list.get(right)[0] - list.get(left)[0];
                    start = list.get(left)[0];
                    end = list.get(right)[0];
                }

                map.put(l[1], map.get(l[1]) - 1);
                if (map.get(l[1]) == 0) count--;

                left++;
            }
        }

        System.out.println("Smallest Range: [" + start + ", " + end + "]");
    }

    public static void internalWorkingOfHashMap() {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(17, "B"); // collision example (same bucket if size=16)

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }

        System.out.println("HashMap uses array + linked list (or tree)");
    }

    public static void separateChaining() {

        int size = 5;
        List<List<Integer>> table = new ArrayList<>();

        for (int i = 0; i < size; i++)
            table.add(new LinkedList<>());

        int[] keys = {10, 15, 20, 25};

        for (int key : keys) {
            int index = key % size;
            table.get(index).add(key);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table.get(i));
        }
    }

    public static void hashTableWithChaining() {

        int size = 5;
        List<List<Integer>> table = new ArrayList<>();

        for (int i = 0; i < size; i++)
            table.add(new LinkedList<>());

        // Insert
        int[] keys = {10, 20, 15, 7};
        for (int key : keys) {
            int index = key % size;
            table.get(index).add(key);
        }

        // Search
        int searchKey = 15;
        int index = searchKey % size;

        if (table.get(index).contains(searchKey))
            System.out.println("Found: " + searchKey);
        else
            System.out.println("Not Found");
    }

    public static void openAddressing() {

        int size = 5;
        Integer[] table = new Integer[size];

        int[] keys = {10, 20, 15, 7};

        for (int key : keys) {
            int index = key % size;

            while (table[index] != null) {
                index = (index + 1) % size; // linear probing
            }

            table[index] = key;
        }

        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }



    // 1. Country -> Capital
    public static void countryToCapital() {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("India", "New Delhi");
        countryCapitalMap.put("USA", "Washington D.C.");
        countryCapitalMap.put("Japan", "Tokyo");

        System.out.println("Country -> Capital:");
        for (Map.Entry<String, String> entry : countryCapitalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // 2. Employee ID -> Name
    public static void employeeIdToName() {
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");
        employeeMap.put(104, "David");

        System.out.println("Employee ID -> Name:");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // 3. City -> Population
    public static void cityToPopulation() {
        Map<String, Integer> cityPopulationMap = new HashMap<>();
        cityPopulationMap.put("Ottawa", 1000000);
        cityPopulationMap.put("Toronto", 3000000);
        cityPopulationMap.put("Montreal", 2000000);
        cityPopulationMap.put("Vancouver", 1500000);

        System.out.println("City -> Population:");
        for (Map.Entry<String, Integer> entry : cityPopulationMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // 4. Product -> Price
    public static void productToPrice() {
        Map<String, Double> productPriceMap = new HashMap<>();
        productPriceMap.put("Laptop", 1200.50);
        productPriceMap.put("Smartphone", 800.99);
        productPriceMap.put("Headphones", 150.75);
        productPriceMap.put("Monitor", 300.00);

        System.out.println("Product -> Price:");
        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
        System.out.println();
    }

    // 5. Employee ID -> Department
    public static void employeeIdToDepartment() {
        Map<Integer, String> employeeDeptMap = new HashMap<>();
        employeeDeptMap.put(101, "HR");
        employeeDeptMap.put(102, "Finance");
        employeeDeptMap.put(103, "IT");
        employeeDeptMap.put(104, "Marketing");

        System.out.println("Employee ID -> Department:");
        for (Map.Entry<Integer, String> entry : employeeDeptMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }


    // 1. Create a HashSet and print its elements
    public static void hashSetExample() {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Mango");

        System.out.println("HashSet Elements:");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }

    // 2. Check if a particular element exists in a HashSet
    public static void checkElementInHashSet() {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        int search = 20;
        System.out.println("Does HashSet contain " + search + "? " + numbers.contains(search));
        System.out.println();
    }

    // 3. HashMap: Country -> Capital
    public static void countryToCapitalMap() {
        HashMap<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Canada", "Ottawa");
        countryCapital.put("USA", "Washington D.C.");
        countryCapital.put("India", "New Delhi");
        countryCapital.put("Japan", "Tokyo");

        System.out.println("Country -> Capital:");
        for (Map.Entry<String, String> entry : countryCapital.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // 4. Find common elements between two ArrayLists
    public static void commonElementsBetweenLists() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));

        ArrayList<Integer> common = new ArrayList<>(list1);
        common.retainAll(list2); // keep only common elements

        System.out.println("Common Elements between List1 and List2:");
        for (int num : common) {
            System.out.println(num);
        }
        System.out.println();
    }

    // 5. Check if a HashSet is a subset of another HashSet
    public static void checkSubsetHashSet() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

        boolean isSubset = set1.containsAll(set2);
        System.out.println("Is set2 a subset of set1? " + isSubset);
        System.out.println();
    }

    // 1. Remove duplicates from a list while maintaining order
    public static void removeDuplicatesMaintainOrder() {
        List<String> list = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Mango");

        LinkedHashSet<String> set = new LinkedHashSet<>(list);

        System.out.println("List after removing duplicates (order maintained):");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }

    // 2. Preserve order of elements after filtering
    public static void preserveOrderAfterFiltering() {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        // Filter numbers divisible by 10
        LinkedHashSet<Integer> filteredSet = new LinkedHashSet<>();
        for (int num : numbers) {
            if (num % 10 == 0) {
                filteredSet.add(num);
            }
        }

        System.out.println("Filtered numbers divisible by 10 (order preserved):");
        for (int num : filteredSet) {
            System.out.println(num);
        }
        System.out.println();
    }

    // 3. Find first repeating element efficiently
    public static void findFirstRepeatingElement() {
        List<Integer> numbers = Arrays.asList(2, 5, 3, 4, 5, 2, 6);

        Set<Integer> seen = new HashSet<>();
        Integer firstRepeating = null;

        for (int num : numbers) {
            if (seen.contains(num)) {
                firstRepeating = num;
                break;
            } else {
                seen.add(num);
            }
        }

        if (firstRepeating != null) {
            System.out.println("First repeating element: " + firstRepeating);
        } else {
            System.out.println("No repeating element found.");
        }
        System.out.println();
    }
}
