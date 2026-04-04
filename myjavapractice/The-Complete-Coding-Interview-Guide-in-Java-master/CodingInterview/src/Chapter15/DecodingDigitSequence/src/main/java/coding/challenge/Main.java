package Chapter15.DecodingDigitSequence.src.main.java.coding.challenge;

public class Main {

    public static void main(String[] args) {
/*
Great—this is a very important Dynamic Programming problem (commonly asked by Amazon/Microsoft). Let’s break it down clearly 👇

🧩 1. Problem Statement (What is the question?)

You are given a digit sequence (string of numbers).

Each digit maps to a letter:

Digit	Letter
1	A
2	B
...	...
26	Z

👉 Task:
Count how many different ways the given sequence can be decoded into letters.

📌 Example
Input: "1234"

Possible decodings:

1 2 3 4 → ABCD
12 3 4  → LCD
1 23 4  → AWD

👉 Output:

3 ways
🧠 2. Clear Analysis
🔍 Key Idea

At each position, you have two choices:

1️⃣ Take 1 digit
If it's not '0'
Example: 1 → A
2️⃣ Take 2 digits
If number is between 10 and 26
Example: 12 → L
⚠️ Important Rules
'0' cannot be decoded alone ❌
Valid pairs:
10 → J
20 → T
Invalid:
30, 01, 00
🧠 Recurrence Relation

Let dp[i] = number of ways to decode first i digits

dp[i] = dp[i-1]  (if single digit valid)
      + dp[i-2]  (if two digits valid)
🧠 Example Walkthrough ("123")
dp[0] = 1
dp[1] = 1  ("1")

dp[2]:
  "2" valid → dp[1]
  "12" valid → dp[0]
  → dp[2] = 2

dp[3]:
  "3" valid → dp[2]
  "23" valid → dp[1]
  → dp[3] = 3
⚙️ 3. Solution Approach
✅ Approach 1: Recursion (Simple but Slow)
Try all combinations
Time: O(2^n) ❌
✅ Approach 2: Dynamic Programming (Optimal)
Build solution from smaller subproblems
Time: O(n)
 */
        /*
        1 2 3 2 1 1
        12 3 2 1 1 
        12 3 21 1
        12 3 2 11
        1 23 2 1 1
        1 23 21 1
        1 23 2 11
        1 2 3 11
        1 2 3 21 1
        */
        char digits[] = {'1', '2', '3', '2', '1', '1'};                
        
        System.out.println("Recursive approach: " + Digits.decoding(digits, digits.length));
        System.out.println("DP approach: " + Digits.decoding(digits));



        //✅ Optimal DP Solution (Recommended)
        System.out.println(countDecodings("1234")); // Output: 3
        //⚡ Space Optimized Version (Advanced)
        System.out.println(countDecodings("1234")); // Output: 3
    }

    public static int countDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; // empty string
        dp[1] = 1; // first digit

        for (int i = 2; i <= n; i++) {

            // Check single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }


    public static int countDecodingsOptimized(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 2; i <= s.length(); i++) {

            int current = 0;

            if (s.charAt(i - 1) != '0') {
                current += prev1;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
