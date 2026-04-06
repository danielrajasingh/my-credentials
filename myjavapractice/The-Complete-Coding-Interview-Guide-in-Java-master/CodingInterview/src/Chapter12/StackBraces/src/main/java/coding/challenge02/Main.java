package Chapter12.StackBraces.src.main.java.coding.challenge02;
 
public class Main {

    public static void main(String[] args) {

        String goodBracesStr = "{}{{{}}}{{}}{}";
        String wrongBracesStr = "{}{{{}}}{{}{{}";

        System.out.println("Good (should return true): " 
                + StackBraces.bracesMatching(goodBracesStr));
        
        System.out.println("Wrong (should return false): " 
                + StackBraces.bracesMatching(wrongBracesStr));
    }
}
