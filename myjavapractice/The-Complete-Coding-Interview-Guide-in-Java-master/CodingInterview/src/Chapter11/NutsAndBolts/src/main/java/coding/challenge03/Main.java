package Chapter11.NutsAndBolts.src.main.java.coding.challenge03;
 
public class Main {
    /*
    Here’s your complete interview-ready breakdown for Coding Challenge 3 – Nuts and Bolts 👇

✅ 1. What is the Question?
    👉 You are given:
    Two arrays:
    nuts[]
    bolts[]

    👉 Each nut has exactly one matching bolt (1-to-1 mapping)

    👉 Task:
    Match each nut with its correct bolt
    Use minimum number of iterations (optimize performance)


    🔍 2. Clear Analysis
    ❌ Brute Force Approach
    For each nut → scan all bolts
    Time Complexity → O(n²) (bad)
    ❌ Sorting Approach
    Sort both arrays
    Then match by index
    Time Complexity → O(n log n)
    ✅ Optimal Approach (HashMap)

    👉 Key idea:
    Store all nuts in a HashMap
    Then scan bolts and match instantly
    Why HashMap?
    Lookup → O(1)
    Total → O(n) (best possible)
💡 3. Solution Idea
Step 1:
    Store each nut in map:
    key = nut
    value = index

Step 2:
    Traverse bolts:
    If bolt exists in map → match found
    Else → no match

⚙️ 4. Solution Implementation
import java.util.*;

public class NutsAndBolts {

    public static void match(char[] nuts, char[] bolts) {

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Store nuts
        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }

        // Step 2: Match bolts
        for (int i = 0; i < bolts.length; i++) {
            char bolt = bolts[i];

            if (map.containsKey(bolt)) {
                nuts[i] = bolt;  // align nut with bolt
            } else {
                System.out.println("Bolt " + bolt + " has no nut");
            }
        }

        System.out.println("Nuts: " + Arrays.toString(nuts));
        System.out.println("Bolts: " + Arrays.toString(bolts));
    }
}
🧠 5. One-Line Memory Trick

👉 “Store nuts in map → scan bolts → match in O(1)”

🧪 6. Dry Run Example
Input:
nuts  = ['$', '%', '&', 'x', '@']
bolts = ['%', '@', 'x', '$', '&']
Step 1: Build HashMap
map = {
  '$' → 0
  '%' → 1
  '&' → 2
  'x' → 3
  '@' → 4
}
Step 2: Traverse Bolts
i	Bolt	Exists in Map?	Action
0	%	Yes	nuts[0] = %
1	@	Yes	nuts[1] = @
2	x	Yes	nuts[2] = x
3	$	Yes	nuts[3] = $
4	&	Yes	nuts[4] = &
Final Output:
nuts  = ['%', '@', 'x', '$', '&']
bolts = ['%', '@', 'x', '$', '&']

✅ Both aligned → matched

🎨 7. Mental Visualization
Step 1: Map Creation
nuts → HashMap

'$' → 0
'%' → 1
'&' → 2
'x' → 3
'@' → 4
Step 2: Matching Flow
bolts[i] → check in map → match

        bolts[]
   ┌───────────────┐
   │  %  @  x  $  &│
   └───────────────┘
         ↓ ↓ ↓ ↓ ↓
      HashMap lookup
         ↓ ↓ ↓ ↓ ↓
   ┌───────────────┐
   │   MATCH FOUND │
   └───────────────┘
         ↓
     Update nuts[]
Final Alignment
nuts  →  %  @  x  $  &
bolts →  %  @  x  $  &
           ✔ ✔ ✔ ✔ ✔
🎯 Interview Gold Insight

⚠️ Important to mention:

👉 This solution assumes:

Matching is based on direct equality
No comparison constraints (like real nuts & bolts problem)

👉 In real interview:

Classic problem may require custom comparator
Cannot compare nut-to-nut or bolt-to-bolt directly
🚀 Final Summary
Brute force → O(n²) ❌
Sorting → O(n log n) ❌
HashMap → O(n) ✅

If you want next level 🔥
I can show:
✅
Advanced “real nuts & bolts” problem (QuickSort partition trick)
✅
Edge cases interviewer may ask
✅
Optimized in-place matching

Just tell me 👍
     */
    public static void main(String[] args) {
        
        char[] nuts = {'$', '%', '&', 'x', '@'};
        char[] bolts = {'%', '@', 'x', '$', '&'};
        
        NutsBolts.match(nuts, bolts);
    }
    
}
