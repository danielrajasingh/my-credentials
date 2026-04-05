package Chapter15.RomanNumbers.src.main.java.coding.challenge;
 
public class Main {
    /*
        🧩 1. Problem Statement (What is the question?)

        You are given a positive integer n.

        👉 Write a program to convert this integer into its Roman numeral representation.

        Example:
        n = 34 → "XXXIV"
        n = 49 → "XLIX"
        n = 145 → "CXLV"

        🧠 2. Clear Analysis
        📌 Roman Numeral Basics
        Value	Symbol
        1	I
        5	V
        10	X
        50	L
        100	C
        500	D
        1000	M
        ⚠️ Special Cases (Important!)

        Roman numerals are not purely additive.

        Some numbers use subtraction notation:

        Number	Roman
        4	IV
        9	IX
        40	XL
        90	XC
        400	CD
        900	CM
        🔍 Key Idea

        Instead of thinking digit-by-digit, use a greedy approach:

        👉 Always subtract the largest possible Roman value from n

        🧠 Example Walkthrough (n = 34)
        34 → 10 + 10 + 10 + 4
           → X  + X  + X  + IV
           → XXXIV
        🧠 Example (n = 49)
        49 → 40 + 9
           → XL + IX
           → XLIX
        ⚙️ 3. Solution Approach (Greedy Algorithm)
        Steps:
        Create two arrays:
        Roman values (descending)
        Roman symbols
        Loop through values:
        While n >= value
        Append symbol
        Subtract value from n
        Continue until n = 0
        * */
    public static void main(String[] args) {

        int n1 = 96;
        int n2 = 4000;
        int n3 = 73;
        int n4 = 558;

        System.out.println("\n" + n1 + " is:\n"
                + RomanNumbers.convert1(n1) + "\n" + RomanNumbers.convert2(n1));
        System.out.println("\n" + n2 + " is:\n"
                + RomanNumbers.convert1(n2) + "\n" + RomanNumbers.convert2(n2));
        System.out.println("\n" + n3 + " is:\n"
                + RomanNumbers.convert1(n3) + "\n" + RomanNumbers.convert2(n3));
        System.out.println("\n" + n4 + " is:\n"
                + RomanNumbers.convert1(n4) + "\n" + RomanNumbers.convert2(n4));



        // ✅ Clean & Interview-Ready Code
        System.out.println(toRoman(34));  // XXXIV
        System.out.println(toRoman(49));  // XLIX
        System.out.println(toRoman(145)); // CXLV
    }






    public static String toRoman(int n) {

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4,
                1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV",
                "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (n >= values[i]) {
                result.append(symbols[i]);
                n -= values[i];
            }
        }

        return result.toString();
    }
}
