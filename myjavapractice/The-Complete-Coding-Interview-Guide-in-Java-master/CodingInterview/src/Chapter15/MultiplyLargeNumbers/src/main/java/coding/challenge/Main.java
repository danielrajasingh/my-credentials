package Chapter15.MultiplyLargeNumbers.src.main.java.coding.challenge;

public class Main {
/*
This is a very common Big Integer problem asked in Amazon/Microsoft interviews. Let’s break it down step-by-step so you fully understand it 👇

✅ 1. What is the Question?

You are given two very large numbers as strings:

a = "4145775"
b = "771467"

👉 You must:

Return their multiplication result as a string

❗ Constraint
You cannot use:
int
long
BigInteger (in interviews usually ❌)

👉 Because numbers are too large to fit in standard data types

✔️ Example
Input:
a = "4145775"
b = "771467"

Output:
"3198328601925"
✅ 2. Key Idea (Core Concept 🔥)

👉 Simulate manual multiplication (school method)

      4145775
   ×   771467
  ----------------
      (7 × 4145775)
     (6 × 4145775) shifted
    (4 × 4145775) shifted
   ...
  ----------------
   Final Sum
✅ 3. Important Observations
Multiply digit by digit
Keep track of:
carry
position (shift)
Store result in an array of size lenA + lenB

👉 Why?
Max digits after multiplication = lenA + lenB

✅ 4. Algorithm (Step-by-Step)
🔹 Step 1: Initialize result array
int[] result = new int[lenA + lenB]
🔹 Step 2: Traverse from right to left

For each digit in a:

Multiply with each digit in b
🔹 Step 3: Multiply and add
sum = (digitA * digitB) + existing_value + carry
🔹 Step 4: Update
result[position] = sum % 10
carry = sum / 10
🔹 Step 5: Handle carry after inner loop
🔹 Step 6: Skip leading zeros
🔹 Step 7: Convert to string
✅ 5. Dry Run (Simple Example)
a = "123"
b = "45"

Step:
3×5 → store
3×4 → shift
2×5 → shift
...

Final = 5535

✅ 7. Complexity Analysis
Type	Complexity
Time	O(n × m)
Space	O(n + m)

Where:

n = length of a
m = length of b
✅ 8. Edge Cases 🚨
Case	Output
"0" × anything	"0"
"1" × number	same number
Leading zeros	handle properly
Very large input	works fine
✅ 9. Common Interview Mistakes ❌
❌ Using int or long
❌ Forgetting carry handling
❌ Wrong index placement (i + j vs i + j + 1)
❌ Not skipping leading zeros
❌ String concatenation in loop (use StringBuilder)
✅ 10. Short Interview Answer (Perfect Summary)

Simulate manual multiplication by multiplying digits from right to left, store intermediate results in an array, handle carry, and finally build the result string.

🚀 Bonus (Interview Follow-ups)

They may ask:

👉 Can you handle negative numbers?
👉 Can you implement addition of large numbers?
👉 Can you optimize space?
👉 Can you do this in-place?


 */
    public static void main(String[] args) {

        // result 3198328601925
        String a = "4145775";
        String b = "771467";
               
        String result = Numbers.multiply(a, b);
        System.out.print(result);

        // chat gbt code..
        System.out.println(multiply("4145775", "771467"));
        // Output: 3198328601925
    }



    public static String multiply(String a, String b) {

        if (a.equals("0") || b.equals("0")) return "0";

        int lenA = a.length();
        int lenB = b.length();

        int[] result = new int[lenA + lenB];

        // Traverse both numbers from right to left
        for (int i = lenA - 1; i >= 0; i--) {
            int n1 = a.charAt(i) - '0';
            int carry = 0;

            for (int j = lenB - 1; j >= 0; j--) {
                int n2 = b.charAt(j) - '0';

                int sum = n1 * n2 + result[i + j + 1] + carry;

                result[i + j + 1] = sum % 10;
                carry = sum / 10;
            }

            result[i] += carry;
        }

        // Convert array to string (skip leading zeros)
        StringBuilder sb = new StringBuilder();

        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
