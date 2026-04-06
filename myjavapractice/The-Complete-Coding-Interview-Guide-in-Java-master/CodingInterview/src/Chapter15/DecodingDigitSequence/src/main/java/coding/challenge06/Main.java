package Chapter15.DecodingDigitSequence.src.main.java.coding.challenge06;

public class Main {

    public static void main(String[] args) {
/*
            This is a very important Dynamic Programming problem (same as the famous Decode Ways problem). Let’s break it down clearly 👇

            ✅ 1. What is the Question?

            You are given a string of digits (e.g., "1234").

            Each digit (or pair of digits) maps to a letter:

            1 → A
            2 → B
            ...
            26 → Z

            👉 You must:

            Count how many different ways the digit string can be decoded into letters

            🔍 Example
            Input: "1234"

            Possible decodings:
            1 2 3 4  → ABCD
            12 3 4   → LCD
            1 23 4   → AWD

            Output: 3
            ✅ 2. Constraints (Important 🚨)
            Digits: 0–9
            ❌ No leading 0
            ❌ No invalid sequences like:
            "06" (invalid)
            "100" (invalid decoding)
            ✔️ Valid pairs: 10 to 26
            ✅ 3. Key Idea (Core Insight 🔥)

            At every position, you have two choices:

            🔹 Option 1: Take 1 digit
            If it's not '0', decode it
            🔹 Option 2: Take 2 digits
            If number is between 10–26, decode it
            ✅ 4. Recursive Thinking

            Let:

            f(n) = number of ways to decode first n digits

            Then:

            f(n) = f(n-1) + f(n-2)

            👉 BUT only when valid!

            ✅ 5. Why Recursion is Bad ❌
            Recomputes same subproblems
            Time complexity: O(2ⁿ)

            👉 So we use Dynamic Programming

            ✅ 6. DP Approach (Efficient 🚀)
            🔹 Define:
            dp[i] = number of ways to decode first i digits
            🔹 Base Cases:
            dp[0] = 1   (empty string)
            dp[1] = 1   (if first digit ≠ 0)
            🔹 Transition:

            For each i:

            If last digit is valid:
            dp[i] += dp[i-1]
            If last two digits form valid number (10–26):
            dp[i] += dp[i-2]
            ✅ 7. Example Walkthrough
            Input: "1234"
            i=1 → "1" → 1 way
            i=2 → "12" → 2 ways
            i=3 → "123" → 3 ways
            i=4 → "1234" → 3 ways
            ✅ 8. Java Implementation (DP)
            public class DecodeWays {

                public static int countDecodings(String s) {

                    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                        return 0;
                    }

                    int n = s.length();
                    int[] dp = new int[n + 1];

                    dp[0] = 1;
                    dp[1] = 1;

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

                public static void main(String[] args) {
                    System.out.println(countDecodings("1234")); // Output: 3
                    System.out.println(countDecodings("226"));  // Output: 3
                    System.out.println(countDecodings("06"));   // Output: 0
                }
            }
            ✅ 9. Optimized Space (O(1))
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
            ✅ 10. Complexity Analysis
            Type	Complexity
            Time	O(n)
            Space	O(n) → DP
            Space Optimized	O(1)
            ✅ 11. Edge Cases 🚨
            Input	Output	Reason
            "0"	0	invalid
            "10"	1	only "J"
            "100"	0	invalid
            "26"	2	Z, BF
            "06"	0	invalid
            ✅ 12. Common Mistakes ❌
            ❌ Treating "0" as valid single digit
            ❌ Ignoring "10" and "20"
            ❌ Not checking <= 26
            ❌ Using recursion without memoization
            ✅ 13. Short Interview Answer (Perfect Summary)

            At each step, check if one digit or two digits form valid characters, and use dynamic programming to count total decoding ways.

            🚀 Bonus (Follow-up Questions)

            They may ask:

            👉 Print all decoding combinations
            👉 Handle very large strings
            👉 Use recursion + memoization
            👉 Count only valid English words (hard)

            If you want next level:

            I can give visual DP table explanation
            Or convert to recursion + memoization
            Or give a Google-level tricky variant 🔥
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
