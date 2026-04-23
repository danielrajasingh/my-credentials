package medium;
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[k++] = nums[i];
        }
        return k;
    }
    public static void main(String[] args) { System.out.println("k = " + removeDuplicates(new int[]{1,1,2})); }
}
