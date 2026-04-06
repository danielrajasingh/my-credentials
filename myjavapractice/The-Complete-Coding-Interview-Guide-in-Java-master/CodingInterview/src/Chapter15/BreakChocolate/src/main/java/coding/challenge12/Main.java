package Chapter15.BreakChocolate.src.main.java.coding.challenge12;
 
public class Main {
 /*
 Great—this is a logic + case-based problem (not heavy coding, but careful reasoning). Let’s break it down clearly 👇

🧩 1. Problem Statement (What is the question?)

You are given:

A chocolate bar of size width × height
Total tiles = width × height
A target number nTiles

👉 You can make cuts:

Only horizontal or vertical
Each cut splits a piece into two rectangles

👉 Goal:
Find the minimum number of cuts required to get a piece with exactly nTiles tiles

👉 If not possible → return -1

📌 Example
Chocolate: 3 × 6 = 18 tiles
Target: nTiles = 6

👉 Output:

1 cut
🧠 2. Clear Analysis
🔍 Key Observations
✅ Case 1: Invalid Input
nTiles > width × height → NOT possible
✅ Case 2: Exact Match
nTiles == width × height → 0 cuts
✅ Case 3: One Cut Enough

If we can form a rectangle directly with one cut:

👉 That means:

nTiles = width × some height
OR
nTiles = height × some width
nTiles % width == 0
OR
nTiles % height == 0

👉 Then answer = 1 cut

✅ Case 4: Two Cuts Needed

If:

We can form a rectangle (a × b)
But not aligned fully with width/height

👉 Then:

a × b = nTiles

And:

a ≤ width AND b ≤ height

👉 Then answer = 2 cuts

❌ Case 5: Not Possible

If no valid rectangle can be formed → return -1

⚙️ 3. Solution Approach
Steps:
Check invalid cases
Check exact match → return 0
Check if 1 cut possible
Check if 2 cuts possible (factor pairs)
Else return -1

📊 5. Complexity Analysis
Step	Complexity
Basic checks	O(1)
Factor loop	O(√n)
Total	O(√n)
🎯 6. Interview Key Points
✅ You should say:
“This is a case-based problem”
“We minimize cuts (0, 1, or 2)”
“Use factorization for 2-cut case”
⚠️ Common Mistakes
Not checking invalid cases ❌
Forgetting width/height constraints ❌
Not considering factor pairs ❌
🚀 7. Pro Insight

👉 Maximum cuts needed = 2

Why?

First cut → split main bar
Second cut → extract exact piece
🧠 Bonus

👉 Interview follow-up:

“Can you return actual cut positions?”
“What if more than 2 cuts allowed?”
“What if irregular shapes allowed?”
  */
    public static void main(String[] args) {

        int result = Chocolates.breakit(12, 10, 8);
        
        System.out.println("(-1: not possible; 0: no breaks needed; "
                + "1: one break; 2: two breaks): " + result);



        //
        System.out.println(minCuts(3, 6, 18)); // 0
        System.out.println(minCuts(3, 6, 6));  // 1
        System.out.println(minCuts(3, 6, 8));  // 2
        System.out.println(minCuts(3, 6, 20)); // -1
    }

    public static int minCuts(int width, int height, int nTiles) {

        // Invalid input
        if (width <= 0 || height <= 0 || nTiles <= 0) {
            return -1;
        }

        int total = width * height;

        // Case 1: Not possible
        if (nTiles > total) {
            return -1;
        }

        // Case 2: No cuts needed
        if (nTiles == total) {
            return 0;
        }

        // Case 3: One cut possible
        if ((nTiles % width == 0 && (nTiles / width) <= height) ||
                (nTiles % height == 0 && (nTiles / height) <= width)) {
            return 1;
        }

        // Case 4: Two cuts possible
        for (int i = 1; i <= Math.sqrt(nTiles); i++) {
            if (nTiles % i == 0) {

                int a = i;
                int b = nTiles / i;

                if ((a <= width && b <= height) ||
                        (a <= height && b <= width)) {
                    return 2;
                }
            }
        }

        // Case 5: Not possible
        return -1;
    }
}
