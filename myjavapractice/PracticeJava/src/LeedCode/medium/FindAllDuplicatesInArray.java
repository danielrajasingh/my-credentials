package medium;
import java.util.*;
public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) result.add(num);
        }
        return result;
    }
    public static void main(String[] args) { System.out.println("Duplicates: " + findDuplicates(new int[]{4,3,2,7,8,2,3,1})); }
}
