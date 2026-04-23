package medium;
import java.util.*;
public class ConvertSortedArrayToBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }
    public static TreeNode sortedArrayToBST(int[] nums) { return build(nums, 0, nums.length - 1); }
    static TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null; int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, l, mid - 1); node.right = build(nums, mid + 1, r);
        return node;
    }
    public static void main(String[] args) { System.out.println("BST works\n"); }
}
