package easy;
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2, val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) { System.out.println("Found: " + searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13)); }
}
