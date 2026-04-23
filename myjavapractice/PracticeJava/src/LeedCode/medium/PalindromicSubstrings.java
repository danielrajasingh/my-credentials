package medium;
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            count += countPalin(s, i, i) + countPalin(s, i, i + 1);
        }
        return count;
    }
    static int countPalin(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++; l--; r++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Palindromic: " + countSubstrings("abc"));
    }
}
