package medium;
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
    public static void main(String[] args) { System.out.println("Min: " + findMin(new int[]{3,4,5,1,2})); }
}
