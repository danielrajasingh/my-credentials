package Chapter11.NutsAndBolts.src.main.java.coding.challenge;
 
public class Main {
    
    public static void main(String[] args) {
        
        char[] nuts = {'$', '%', '&', 'x', '@'};
        char[] bolts = {'%', '@', 'x', '$', '&'};
        
        NutsBolts.match(nuts, bolts);
    }
    
}
