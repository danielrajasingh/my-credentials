package Chapter10.EncodedString.src.main.java.coding.challenge03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        char[] str = "x ".toCharArray();                

        System.out.println("Before: " + Arrays.toString(str));        
        
        char[] result = Strings.encodeWhitespaces(str);
        
        System.out.println("After: " + Arrays.toString(result));        
    }

}
