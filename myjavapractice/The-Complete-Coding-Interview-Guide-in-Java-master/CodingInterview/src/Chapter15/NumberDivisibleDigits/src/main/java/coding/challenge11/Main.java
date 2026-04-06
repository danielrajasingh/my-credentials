package Chapter15.NumberDivisibleDigits.src.main.java.coding.challenge11;
 
public class Main {

    /*
    ✅ 1. What is the Question?

    You are given an integer n.

    👉 You need to check:

    Is the number divisible by each of its digits?

    ✔️ Return:
    true → if n is divisible by all its digits
    false → if it is not divisible by any one of its digits
    🔍 Example 1
    n = 412
    Digits = 4, 1, 2

    Check:

    412 % 4 == 0 ✅
    412 % 1 == 0 ✅
    412 % 2 == 0 ✅

    👉 Output: true

    🔍 Example 2
    n = 143
    Digits = 1, 4, 3

    Check:

    143 % 1 == 0 ✅
    143 % 4 != 0 ❌
    143 % 3 != 0 ❌

    👉 Output: false

    ✅ 2. Key Observations (Important in Interview)

    You must extract digits using:

    n % 10

    Remove last digit using:

    n = n / 10
    ⚠️ Handle digit = 0 carefully
    Division by zero is not allowed
    Ignore digit 0
    ✅ 3. Algorithm (Step-by-Step)
    Store original number → t = n
    Loop while n > 0
    Extract digit → digit = n % 10
    If digit ≠ 0:
    Check t % digit
    If not divisible → return false
    Remove digit → n = n / 10
    If all digits pass → return true


    ✅ 5. Complexity Analysis
    Time Complexity:
    O(d) → where d = number of digits (≈ log₁₀ n)
    Space Complexity:
    O(1) → no extra space used
    ✅ 6. Edge Cases (Very Important 🚨)
    Case	Expected Behavior
    n = 0	return true (or define based on requirement)
    Contains 0 digit	skip it
    Negative numbers	usually convert to abs(n)
    ✅ 7. Common Mistakes (Interview Trap ⚠️)
    ❌ Forgetting digit == 0
    ❌ Using modified n instead of original value
    ❌ Not handling negative numbers
    ❌ Returning true too early
    ✅ 8. Clean Interview Answer (Short Version)

    Extract each digit using modulo, check divisibility with the original number, skip zero digits, and return false if any digit fails—otherwise return true.

     */
    public static void main(String[] args) {

        System.out.println("1: " + Numbers.isDivisible(1));
        System.out.println("6242: " + Numbers.isDivisible(6242));
        System.out.println("123: " + Numbers.isDivisible(123));
        System.out.println("46: " + Numbers.isDivisible(46));
        System.out.println("144: " + Numbers.isDivisible(144));
        System.out.println("250: " + Numbers.isDivisible(250));
        System.out.println("1030: " + Numbers.isDivisible(1030));
        System.out.println("1010: " + Numbers.isDivisible(1010));
    }
}

