package Chapter08.Staircase.src.main.java.coding.challenge13;
 
public class Main {

    private static final int STEPS = 3;
    
    public static void main(String[] args) {        
                
        int count = Staircase.count(STEPS);                
        System.out.println("Count: " + count);
        
        int countMemo = Staircase.countViaMemoization(STEPS);
        System.out.println("Count via memo: " + countMemo);
    }

}
