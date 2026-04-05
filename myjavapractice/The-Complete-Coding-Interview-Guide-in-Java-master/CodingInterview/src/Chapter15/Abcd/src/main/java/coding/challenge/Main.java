package Chapter15.Abcd.src.main.java.coding.challenge;
 
public class Main {
        /*
                ✅ 1. What is the Question?
                You need to find a 4-digit number ABCD such that:
                When you multiply it by 4, the result becomes DCBA (reverse of the number).
                🔍 Example Format
                ABCD × 4 = DCBA

                Where:
                A, B, C, D are digits
                A ≠ 0 (since it's a 4-digit number)

                ✅ 2. Understanding the Problem
                Let’s represent the number mathematically:
                ABCD = 1000A + 100B + 10C + D
                DCBA = 1000D + 100C + 10B + A

                👉 Given condition:
                4 × (1000A + 100B + 10C + D) = (1000D + 100C + 10B + A)

                ✅ 3. Key Observations (Important 🔥)
                ✔️ 1. Range of number
                Minimum: 1000
                Maximum: 2499
                👉 Because:
                2500 × 4 = 10000 (5 digits ❌)
                ✔️ 2. Digit constraints
                A ∈ [1–2]
                D likely large (because result starts with D after multiplication)
                ✔️ 3. Last digit logic

                From:

                ABCD × 4 → ends with A

                👉 So:

                4 × D → last digit = A

                Try possibilities:

                If A = 2 → D must be 8 (because 4×8 = 32 → last digit 2 ✅)
                ✔️ 4. So we get:
                A = 2
                D = 8
                ✔️ 5. Try solving remaining digits

                Eventually solving gives:

                ABCD = 2178
                ✅ 4. Final Answer
                2178 × 4 = 8712

                ✔️ Reverse of 2178 is 8712
                ✔️ Condition satisfied

                ✅ 5. Approach 1: Mathematical (Optimized Thinking)
                Use digit constraints
                Reduce possibilities
                Solve equations

                👉 Efficient but harder to derive in interview

                ✅ 6. Approach 2: Brute Force (Recommended in Interview)

                👉 Try all 4-digit numbers and check condition

                ✅ 7. Algorithm (Brute Force)
                Loop from 1000 → 2499
                Multiply number by 4
                Reverse result
                Compare with original
                If equal → answer found
                ✅ 8. Java Implementation
                public class ABCDProblem {

                    public static void findNumber() {

                        for (int i = 1000; i <= 2499; i++) {

                            int original = i;
                            int multiplied = i * 4;

                            // Reverse multiplied number
                            String reversed = new StringBuilder(String.valueOf(multiplied))
                                                .reverse().toString();

                            if (String.valueOf(original).equals(reversed)) {
                                System.out.println("Found: " + original);
                                System.out.println(original + " × 4 = " + multiplied);
                                break;
                            }
                        }
                    }

                    public static void main(String[] args) {
                        findNumber();
                    }
                }
                ✅ 9. Complexity Analysis
                Type	Complexity
                Time	O(n × d) (n ≈ 1500, d = digits)
                Space	O(1)

                👉 Very efficient for this problem

                ✅ 10. Common Mistakes ❌
                ❌ Not limiting range to 4-digit numbers
                ❌ Forgetting reverse logic
                ❌ Using string incorrectly
                ❌ Ignoring leading digit constraint (A ≠ 0)
                ✅ 11. Short Interview Answer (Perfect Summary)

                Iterate through all 4-digit numbers,
                multiply each by 4,
                reverse the result,
                and check if it equals the original number.
         */
    public static void main(String[] args) {

        Abcd.find();
    }
}
