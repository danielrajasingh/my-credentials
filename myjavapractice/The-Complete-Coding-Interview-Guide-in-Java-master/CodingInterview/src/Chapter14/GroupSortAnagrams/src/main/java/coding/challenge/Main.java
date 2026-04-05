package Chapter14.GroupSortAnagrams.src.main.java.coding.challenge;
 
import java.util.Arrays;

public class Main {
/*
Let’s go step by step: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

You are given:

👉 An array of words (strings)
👉 These words contain anagrams (words with the same characters in different order)

🔹 Task

👉 Group all anagrams together and print them as groups

🔹 Example
Input:
["calipers", "caret", "slat", "cater", "trace", "crate", "last", "salt"]

Output (grouped):
[
  ["calipers", "spiracle", "replicas"],
  ["caret", "cater", "trace", "crate"],
  ["slat", "last", "salt"]
]
🧠 2. Clear Analysis of the Problem
🔹 What is an Anagram?

👉 Two words are anagrams if:

They have the same characters
But in a different order

Example:

"listen" → "silent"
🔹 Key Insight

👉 If we sort the characters of a word, all its anagrams become identical.

Example:

Word	Sorted
slat	alst
salt	alst
last	alst

👉 So all these words belong to the same group.

🔹 Strategy
Convert each word into a key
Use a HashMap:
Key → sorted word (or frequency representation)
Value → list of anagrams
🔹 Two Approaches
✅ Approach 1 (Simple but slower)
Sort each word
Use sorted string as key

⏱ Time Complexity: O(n · m log m)
(n = number of words, m = word length)

🚀 Approach 2 (Optimized)
Count character frequency
Use frequency array as key

⏱ Time Complexity: O(n · m)

💡 3. Solution Approach
🔹 Approach 1: Sorting-based
Sort each word
Use sorted word as key
Add original word to map
🔹 Approach 2: Frequency-based (Better)
Count frequency of characters (a–z)
Convert frequency array to string
Use as key in HashMap
💻 4. Implementation
✅ Solution 1: Sorting Approach
import java.util.*;

public class AnagramGrouping {

    public static void groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        System.out.println(map.values());
    }

    public static void main(String[] args) {
        String[] words = {
            "calipers", "caret", "slat", "cater",
            "trace", "crate", "last", "salt"
        };

        groupAnagrams(words);
    }
}
🚀 Solution 2: Optimized (Frequency-based)
import java.util.*;

public class AnagramGroupingOptimized {

    public static void groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {

            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        System.out.println(map.values());
    }

    public static void main(String[] args) {
        String[] words = {
            "calipers", "caret", "slat", "cater",
            "trace", "crate", "last", "salt"
        };

        groupAnagrams(words);
    }
}
🔍 5. Intuition (Very Important)

👉 Think like this:

Anagrams → same characters
Same characters → same “signature”
Use that signature as a key
⚡ 6. Time & Space Complexity
Approach	Time	Space
Sorting	O(n · m log m)	O(n)
Frequency	O(n · m)	O(n)
🚀 7. Key Interview Points

✔ Why sorting works for anagrams
✔ Why HashMap is used
✔ Difference between:

sorting approach
frequency approach

✔ How to optimize from O(nm log m) → O(nm)

🚀 Final Summary
Question: Group anagrams together
Core idea: Use a common key for anagrams
Best solution:
Frequency-based hashing
Time complexity: O(n · m)

If you want next, I can:
✅ Show a step-by-step dry run
✅ Visualize how HashMap evolves
✅ Give interview follow-up questions
✅ Provide tricky edge cases
 */
    public static void main(String[] args) {

        String[] words = {
            "calipers", "caret", "slat", "cater", "thickset", "spiracle", "trace",
            "last", "salt", "bowel", "crate", "loop", "polo", "thickest",
            "below", "thickets", "pool", "elbow", "replicas"
        };

        Anagrams anagrams = new Anagrams();

        System.out.println("\n\nVia hashing (O(nm log m)): ");
        anagrams.printAnagrams(words);

        System.out.println("\n\nVia hashing (O(nm)): ");
        anagrams.printAnagramsOptimized(words);

        System.out.println("\n\nVia Comparator (O(nm log m)): ");
        Arrays.sort(words, new Anagrams());
        System.out.println(Arrays.toString(words));
    }
}
