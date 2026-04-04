package Chapter15.RomanNumbers.src.main.java.coding.challenge;
 
public class Main {

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
