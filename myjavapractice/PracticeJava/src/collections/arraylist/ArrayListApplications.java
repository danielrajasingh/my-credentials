package collections.arraylist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
✅ retainAll() → simple and straightforward; modifies the original list (make a copy if you want to keep the original intact).

✅ Streams + filter() → functional programming approach; keeps original lists unchanged.

✅ Use distinct() → when the lists may have duplicates and you only want the unique intersection.

✅ Works for any type:
   - Strings, Integers, Doubles
   - Custom objects (ensure equals() is properly implemented for correct comparison).

✅ Advantage of Streams → can combine with filter, map, reduce, or custom comparators for more complex scenarios.

✅ Practical for interviews → demonstrates knowledge of collections, streams, functional programming, and handling duplicates efficiently.
 */
public class ArrayListApplications {
    public static void main(String[] args) {
        /* Program 1:
        Write a program to find the maximum element from an ArrayList of Integers.
         */
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 45, 32, 67, 23, 89, 54));
        System.out.println("ArrayList: " + numbers);
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  1 . Maximum element                               🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // ✅ Approach 1: Using Collections.max()
        int max1 = Collections.max(numbers);
        System.out.println("Maximum element using Collections.max(): " + max1);

        // ✅ Approach 2: Using Streams (Java 8+ feature, works in Java 11)
        int max2 = numbers.stream()
                .max(Integer::compareTo) // or (a,b) -> a.compareTo(b)
                .get(); // get the value from Optional
        System.out.println("Maximum element using Streams: " + max2);

        // ✅ Approach 3: Using lambda + reduce()
        // 🔥 Maximum element using reduce()
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("Maximum element using reduce(): " + max);

        // 🔥 Minimum element using reduce()
        int min = numbers.stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("Minimum element using reduce(): " + min);


        // 🔥  Minimum element
        // ✅ Approach 1: Using Collections.min()
        int min1 = Collections.min(numbers);
        System.out.println("Minimum element using Collections.min(): " + min1);

        // ✅ Approach 2: Using Streams (Java 8+ feature, works in Java 11)
        int min2 = numbers.stream()
                .min(Integer::compareTo) // or (a,b) -> a.compareTo(b)
                .get(); // get the value from Optional
        System.out.println("Minimum element using Streams: " + min2);

        // 🔥  Max and Minimum element for Double

        ArrayList<Double> doublenumbers = new ArrayList<>(Arrays.asList(10.5, 45.2, 32.8, 67.1, 23.0, 89.9, 54.4));
        System.out.println("ArrayList<Double>: " + numbers);

        // Maximum
        double max3 = Collections.max(doublenumbers);
        System.out.println("Maximum element: " + max3);

        // Minimum
        double min3 = Collections.min(doublenumbers);
        System.out.println("Minimum element: " + min3);

        // Using Streams
        double maxStream = doublenumbers.stream().max(Double::compareTo).get();
        double minStream = doublenumbers.stream().min(Double::compareTo).get();
        System.out.println("Maximum using Streams: " + maxStream);
        System.out.println("Minimum using Streams: " + minStream);



        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  2 . Duplicate remove                              🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Sample ArrayList with duplicates
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Apple", "Orange", "Banana", "Mango"
        ));
        System.out.println("Original ArrayList: " + list);

        // ✅ Approach 1: Using LinkedHashSet (preserves order)
        ArrayList<String> listWithoutDuplicates1 = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("After removing duplicates (LinkedHashSet): " + listWithoutDuplicates1);

        // ✅ Approach 2: Using Streams.distinct() (Java 8+)
        ArrayList<String> listWithoutDuplicates2 = list.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("After removing duplicates (Streams.distinct()): " + listWithoutDuplicates2);

        // ✅ Approach 3: Using Lambda + reduce (functional programming trick)
        ArrayList<String> listWithoutDuplicates3 = list.stream()
                .reduce(new ArrayList<String>(),
                        (acc, item) -> {
                            if (!acc.contains(item)) acc.add(item);
                            return acc;
                        },
                        (acc1, acc2) -> {
                            acc1.addAll(acc2.stream().filter(i -> !acc1.contains(i)).collect(Collectors.toList()));
                            return acc1;
                        });
        System.out.println("After removing duplicates (Lambda + reduce): " + listWithoutDuplicates3);



        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  3 . Intersection  two array list                 🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Sample ArrayLists
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Banana", "Mango", "Grapes", "Pineapple"));

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        // ✅ Approach 1: Using retainAll()
        ArrayList<String> intersection1 = new ArrayList<>(list1); // create a copy
        intersection1.retainAll(list2); // retain only elements present in list2
        System.out.println("Intersection using retainAll(): " + intersection1);

        // ✅ Approach 2: Using Streams
        List<String> intersection2 = list1.stream()
                .filter(list2::contains) // keep elements also in list2
                .collect(Collectors.toList());
        System.out.println("Intersection using Streams: " + intersection2);

        // ✅ Approach 3: Using Streams + distinct() to avoid duplicates
        List<String> intersection3 = list1.stream()
                .filter(list2::contains)
                .distinct() // remove duplicates if any
                .collect(Collectors.toList());
        System.out.println("Intersection using Streams + distinct(): " + intersection3);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  3 . shuffle  two array list                 🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Sample ArrayList
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Orange", "Grapes"
        ));
        System.out.println("Original ArrayList: " + fruits);

        // ✅ Shuffle the elements randomly
        Collections.shuffle(fruits);
        System.out.println("Shuffled ArrayList: " + fruits);

        // ✅ Shuffle again
        Collections.shuffle(fruits);
        System.out.println("Shuffled again: " + fruits);

        // ✅ Optional: Using Streams to shuffle (Java 8+)
        List<String> shuffledStream = fruits.stream()
                .sorted((a, b) -> new Random().nextInt(3) - 1)
                .collect(Collectors.toList());
        System.out.println("Shuffled using Streams: " + shuffledStream);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  4 . second largest number                🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        ArrayList<Integer> secondLargestList = new ArrayList<>(Arrays.asList(10, 45, 32, 67, 23, 89, 54));
        System.out.println("ArrayList: " + numbers);

        // ✅ Approach 1: Sort the list in descending order and pick the second element
        ArrayList<Integer> sortedDesc = new ArrayList<>(secondLargestList);
        sortedDesc.sort(Comparator.reverseOrder());
        int secondLargest1 = sortedDesc.get(1);
        System.out.println("Second-largest element (by sorting): " + secondLargest1);

        // ✅ Approach 2: Using Streams (distinct + sorted descending)
        int secondLargest2 = secondLargestList.stream()
                .distinct()                  // remove duplicates
                .sorted(Comparator.reverseOrder())
                .skip(1)                     // skip the largest
                .findFirst()                 // get the second-largest
                .get();                       // get value from Optional
        System.out.println("Second-largest element (using Streams): " + secondLargest2);

        // ✅ Approach 3: Single pass using max tracking (functional style with reduce)
        int largest = secondLargestList.stream().max(Integer::compareTo).get();
        int secondLargest3 = secondLargestList.stream()
                .filter(n -> n < largest)        // ignore the largest
                .max(Integer::compareTo)     // find max among remaining
                .get();
        System.out.println("Second-largest element (using reduce/filter): " + secondLargest3);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  5 . frequency                🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Sample ArrayList
        ArrayList<String> frequenceFruitsList = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Apple", "Orange", "Banana", "Mango", "Apple"
        ));
        System.out.println("ArrayList: " + frequenceFruitsList);

        // ✅ Approach 1: Using Collections.frequency()
        System.out.println("\nFrequency using Collections.frequency():");
        Set<String> uniqueFruits = new HashSet<>(frequenceFruitsList);
        for (String fruit : uniqueFruits) {
            int freq = Collections.frequency(frequenceFruitsList, fruit);
            System.out.println(fruit + " → " + freq);
        }

        // ✅ Approach 2: Using Map
        System.out.println("\nFrequency using Map:");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String fruit : frequenceFruitsList) {
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);
        }
        freqMap.forEach((k, v) -> System.out.println(k + " → " + v));

        // ✅ Approach 3: Using Streams (Java 8+)
        System.out.println("\nFrequency using Streams:");
        Map<String, Long> freqStream = frequenceFruitsList.stream()
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
        freqStream.forEach((k, v) -> System.out.println(k + " → " + v));




        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  6 . kth smallest element.                         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//



        ArrayList<Integer> kthsmallestnumbers = new ArrayList<>(Arrays.asList(10, 45, 32, 67, 23, 89, 54));
        System.out.println("ArrayList: " + kthsmallestnumbers);

        int k = 3; // Find the 3rd smallest element

        // ✅ Approach 1: Sort the list and pick the kth element (index k-1)
        ArrayList<Integer> sortedList = new ArrayList<>(kthsmallestnumbers);
        Collections.sort(sortedList);
        int kthSmallest1 = sortedList.get(k - 1);
        System.out.println("Kth smallest element (by sorting): " + kthSmallest1);

        // ✅ Approach 2: Using Streams (Java 8+)
        int kthSmallest2 = kthsmallestnumbers.stream()
                .sorted()
                .skip(k - 1)     // skip first k-1 elements
                .findFirst()     // pick the kth element
                .get();          // get value from Optional
        System.out.println("Kth smallest element (using Streams): " + kthSmallest2);

        // ✅ Approach 3: Using PriorityQueue (Min-Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(kthsmallestnumbers); // Min-heap
        int kthSmallest3 = 0;
        for (int i = 0; i < k; i++) {
            kthSmallest3 = minHeap.poll(); // remove k-1 smallest elements, kth remains
        }
        System.out.println("Kth smallest element (using PriorityQueue): " + kthSmallest3);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  7 . kth largest element.                         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//



        ArrayList<Integer> kthLargestList = new ArrayList<>(Arrays.asList(10, 45, 32, 67, 23, 89, 54));
        System.out.println("ArrayList: " + kthLargestList);

        int k1 = 3; // Find the 3rd largest element

// ✅ Approach 1: Sort in descending order and pick the kth element
        ArrayList<Integer> sortedDesc1 = new ArrayList<>(kthLargestList);
        sortedDesc1.sort(Comparator.reverseOrder());
        int kthLargest1 = sortedDesc1.get(k1 - 1);
        System.out.println("Kth largest element (by sorting): " + kthLargest1);

// ✅ Approach 2: Using Streams (sorted descending)
        int kthLargest2 = kthLargestList.stream()
                .sorted(Comparator.reverseOrder())
                .skip(k1 - 1)
                .findFirst()
                .get();
        System.out.println("Kth largest element (using Streams): " + kthLargest2);

// ✅ Approach 3: Using PriorityQueue (Min-Heap of size k)
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        for (int num : kthLargestList) {
            minHeap1.offer(num);
            if (minHeap1.size() > k1) {
                minHeap1.poll();
            }
        }
        int kthLargest3 = minHeap1.peek(); // ✅ fixed
        System.out.println("Kth largest element (using Min-Heap): " + kthLargest3);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  8 . merge two list.                         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        ArrayList<String> sourceMergeList1 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango"));
        ArrayList<String> sourceMergeList2 = new ArrayList<>(Arrays.asList("Orange", "Grapes", "Pineapple"));

        System.out.println("sourceMergeList1: " + sourceMergeList1);
        System.out.println("sourceMergeList2: " + sourceMergeList2);

        // ✅ Approach 1: Using addAll()
        ArrayList<String> merged1 = new ArrayList<>(sourceMergeList1); // copy list1
        merged1.addAll(sourceMergeList2);
        System.out.println("Merged using addAll(): " + merged1);

        // ✅ Approach 2: Using Streams (Java 8+)
        List<String> merged2 = Stream.concat(sourceMergeList1.stream(), sourceMergeList2.stream())
                .collect(Collectors.toList());
        System.out.println("Merged using Streams: " + merged2);

        // ✅ Approach 3: Using constructor + addAll()
        ArrayList<String> merged3 = new ArrayList<>();
        merged3.addAll(list1);
        merged3.addAll(sourceMergeList1);
        System.out.println("Merged using new list + addAll(): " + merged3);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  9 . merge Three list.                         🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        ArrayList<String> firstList = new ArrayList<>(Arrays.asList("Apple", "Banana"));
        ArrayList<String> secondList = new ArrayList<>(Arrays.asList("Mango", "Orange"));
        ArrayList<String> thirdList = new ArrayList<>(Arrays.asList("Grapes", "Pineapple"));

        System.out.println("First List: " + firstList);
        System.out.println("Second List: " + secondList);
        System.out.println("Third List: " + thirdList);

        // ✅ Approach 1: Using addAll()
        ArrayList<String> mergedUsingAddAll = new ArrayList<>(firstList);
        mergedUsingAddAll.addAll(secondList);
        mergedUsingAddAll.addAll(thirdList);
        System.out.println("Merged using addAll(): " + mergedUsingAddAll);

        // ✅ Approach 2: Using Streams (Java 8+)
        List<String> mergedUsingStream = Stream.of(firstList, secondList, thirdList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Merged using Streams: " + mergedUsingStream);

        // ✅ Approach 3: Using new list + addAll()
        ArrayList<String> mergedUsingConstructor = new ArrayList<>();
        mergedUsingConstructor.addAll(firstList);
        mergedUsingConstructor.addAll(secondList);
        mergedUsingConstructor.addAll(thirdList);
        System.out.println("Merged using new list + addAll(): " + mergedUsingConstructor);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  10 . Split the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//


        ArrayList<Integer> originalList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        System.out.println("Original List: " + originalList);

        // Check if size is even
        if (originalList.size() % 2 != 0) {
            System.out.println("Cannot split into equal parts (odd number of elements)");
            return;
        }

        int mid = originalList.size() / 2;

        // Split into two equal parts
        List<Integer> firstHalf = new ArrayList<>(originalList.subList(0, mid));
        List<Integer> secondHalf = new ArrayList<>(originalList.subList(mid, originalList.size()));

        System.out.println("First Half: " + firstHalf);
        System.out.println("Second Half: " + secondHalf);



        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  11 . reverse the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//



        // Sample ArrayList
        ArrayList<String> sourcereverselist = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange"));
        System.out.println("Original ArrayList: " + sourcereverselist);

        // ✅ Approach 1: Using Collections.reverse()
        Collections.reverse(sourcereverselist);
        System.out.println("Reversed ArrayList (Collections.reverse()): " + sourcereverselist);

        // ✅ Approach 2: Using Streams + Collectors (Java 8+)
        ArrayList<String> reversedWithStream = new ArrayList<>();
        reversedWithStream = sourcereverselist.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Reversed ArrayList (Streams + Comparator): " + reversedWithStream);

        // ✅ Approach 3: Using simple for-loop
        ArrayList<String> reversedWithLoop = new ArrayList<>();
        for (int i = sourcereverselist.size() - 1; i >= 0; i--) {
            reversedWithLoop.add(sourcereverselist.get(i));
        }
        System.out.println("Reversed ArrayList (for-loop): " + reversedWithLoop);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  12 . copy the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Original ArrayList
        ArrayList<String> copysource = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange"));
        System.out.println("Original ArrayList: " + copysource);

        // ✅ Approach 1: Using constructor
        ArrayList<String> copyList1 = new ArrayList<>(copysource);
        System.out.println("Copied using constructor: " + copyList1);

        // ✅ Approach 2: Using addAll()
        ArrayList<String> copyList2 = new ArrayList<>();
        copyList2.addAll(copysource);
        System.out.println("Copied using addAll(): " + copyList2);

        // ✅ Approach 3: Using Streams
        ArrayList<String> copyList3 = copysource.stream()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Copied using Streams: " + copyList3);

        // ✅ Approach 4: Using Collections.copy() (requires destination list of same size)
        ArrayList<String> copyList4 = new ArrayList<>(Arrays.asList(new String[copysource.size()]));
        Collections.copy(copyList4, copysource);
        System.out.println("Copied using Collections.copy(): " + copyList4);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  13 . sublist from the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Original ArrayList
        ArrayList<String> sublistSource = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Orange", "Grapes", "Pineapple"
        ));
        System.out.println("Original ArrayList: " + sublistSource);

// ✅ Create a sublist from index 1 (inclusive) to 4 (exclusive)
        List<String> subList = sublistSource.subList(1, 4);
        System.out.println("Sublist (index 1 to 3): " + subList);

// ✅ Modify sublist (affects original list)
        subList.set(0, "Blueberry");
        System.out.println("Modified Sublist: " + subList);
        System.out.println("Original List after modifying sublist: " + sublistSource);

// ✅ If you want an independent copy of sublist
        ArrayList<String> subListCopy = new ArrayList<>(sublistSource.subList(2, 5));
        System.out.println("Independent Sublist Copy: " + subListCopy);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  14 . swap from the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Original ArrayList
        ArrayList<String> swapSource = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Orange", "Grapes"
        ));
        System.out.println("Original ArrayList: " + swapSource);

        // ✅ Approach 1: Using Collections.swap()
        Collections.swap(swapSource, 1, 3); // swap element at index 1 with index 3
        System.out.println("After swapping index 1 and 3: " + swapSource);

        // ✅ Approach 2: Using manual swap
        int i = 0, j = 2; // swap first and third element
        String temp = swapSource.get(i);
        swapSource.set(i, swapSource.get(j));
        swapSource.set(j, temp);
        System.out.println("After manual swap index 0 and 2: " + swapSource);

        // ✅ Approach 3: Using lambda/Streams (functional swap copy)
        ArrayList<String> swappedList = new ArrayList<>(swapSource);
        swappedList.set(0, swapSource.get(2));
        swappedList.set(2, swapSource.get(0));
        System.out.println("Functional-style swapped copy: " + swappedList);


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  15 . clone from the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//





        // Original ArrayList
        ArrayList<String> cloneoriginalList = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Orange"
        ));
        System.out.println("Original ArrayList: " + cloneoriginalList);

        // ✅ Approach 1: Using clone()
        ArrayList<String> clonedList1 = (ArrayList<String>) cloneoriginalList.clone();
        System.out.println("Cloned using clone(): " + clonedList1);

        // ✅ Approach 2: Using constructor
        ArrayList<String> clonedList2 = new ArrayList<>(cloneoriginalList);
        System.out.println("Cloned using constructor: " + clonedList2);

        // ✅ Approach 3: Using addAll()
        ArrayList<String> clonedList3 = new ArrayList<>();
        clonedList3.addAll(cloneoriginalList);
        System.out.println("Cloned using addAll(): " + clonedList3);

        // Modify cloned list to show independence
        clonedList1.set(0, "Blueberry");
        System.out.println("After modifying clonedList1: " + clonedList1);
        System.out.println("Original remains unchanged: " + originalList);



        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  16 . test clone from the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        // Original list
        ArrayList<String> testClosedOrNotSourceList = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango", "Orange"
        ));

// Clone the list
        ArrayList<String> testClosedOrNotClonedList = (ArrayList<String>) testClosedOrNotSourceList.clone();

        System.out.println("Source List: " + testClosedOrNotSourceList);
        System.out.println("Cloned List: " + testClosedOrNotClonedList);

// ✅ Check if both lists have same values (and order)
        if (testClosedOrNotSourceList.equals(testClosedOrNotClonedList)) {
            System.out.println("Both lists have SAME values and SAME order");
        } else {
            System.out.println("Lists are NOT equal");
        }

// ✅ Check if both references are same
        if (testClosedOrNotSourceList == testClosedOrNotClonedList) {
            System.out.println("Both lists refer to SAME object");
        } else {
            System.out.println("Both lists are DIFFERENT objects (correct cloning)");
        }

// ✅ Modify cloned list to verify independence
        testClosedOrNotClonedList.set(0, "Blueberry");

        System.out.println("\nAfter modifying cloned list:");
        System.out.println("Source List: " + testClosedOrNotSourceList);
        System.out.println("Cloned List: " + testClosedOrNotClonedList);

// Re-check equality
        if (testClosedOrNotSourceList.equals(testClosedOrNotClonedList)) {
            System.out.println("Still equal");
        } else {
            System.out.println("Now lists are DIFFERENT");
        }


        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  17 . increase capacity from the list.                     🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // Create ArrayList
        ArrayList<String> capacityList = new ArrayList<>();
        capacityList.add("Apple");
        capacityList.add("Banana");
        capacityList.add("Mango");

        System.out.println("ArrayList: " + capacityList);

        // ✅ Increase capacity
        capacityList.ensureCapacity(20);
        System.out.println("Capacity increased to at least 20 (internally)");

        // Add more elements
        capacityList.add("Orange");
        capacityList.add("Grapes");

        System.out.println("Updated ArrayList: " + capacityList);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥  18 . replace capacity from the list.              🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//

        ArrayList<String> sourceList = new ArrayList<>(Arrays.asList(
                "Apple", "Banana", "Mango"
        ));

        ArrayList<String> replacementList = new ArrayList<>(Arrays.asList(
                "Orange", "Grapes", "Pineapple"
        ));

        System.out.println("Source List: " + sourceList);
        System.out.println("Replacement List: " + replacementList);

        // ✅ Approach 1: Clear + addAll()
        ArrayList<String> replacedList1 = new ArrayList<>(sourceList);
        replacedList1.clear();
        replacedList1.addAll(replacementList);
        System.out.println("Replaced using clear + addAll(): " + replacedList1);

        // ✅ Approach 2: Direct assignment (reference change)
        ArrayList<String> replacedList2 = sourceList;
        replacedList2 = replacementList;
        System.out.println("Replaced using assignment: " + replacedList2);

        // ✅ Approach 3: Replace element-wise (same size)
        ArrayList<String> replacedList3 = new ArrayList<>(sourceList);
        for (int p = 0; p < replacementList.size(); p++) {
            replacedList3.set(j, replacementList.get(p));
        }
        System.out.println("Replaced element-wise: " + replacedList3);

        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//
        // 🔥                                                    🔥//
        // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥//



    }
}
