package Chapter15.RomanNumbers.src.main.java.coding.challenge;
 
public final class RomanNumbers {
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


    // the following constants are used by convert1()
    private static final String HUNDREDTHS[]
            = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String TENS[]
            = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String ONES[]
            = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // the following constants are used by convert2()
    private static final int[] DECIMALS
            = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS
            = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* using division */
    public static String convert1(int n) {

        if (n <= 0) {
            return "";
        }

        String roman = "";

        while (n >= 1000) {
            roman = roman + 'M';
            n -= 1000;
        }

        roman = roman + HUNDREDTHS[n / 100];
        n = n % 100;

        roman = roman + TENS[n / 10];
        n = n % 10;

        roman = roman + ONES[n];

        return roman;
    }

    /* using subtraction */
    public static String convert2(int n) {

        if (n <= 0) {
            return "";
        }

        String roman = "";
        int i = 0;

        while (n > 0) {
            if (n >= DECIMALS[i]) {
                roman += ROMANS[i];
                n -= DECIMALS[i];
            } else {
                i++;
            }
        }

        return roman;
    }
}
