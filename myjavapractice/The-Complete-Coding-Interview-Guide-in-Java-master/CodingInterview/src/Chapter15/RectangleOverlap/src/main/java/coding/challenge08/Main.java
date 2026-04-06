package Chapter15.RectangleOverlap.src.main.java.coding.challenge08;

public class Main {

    /*
            This is a classic geometry + logic problem frequently asked in interviews. Let’s break it down clearly so you can explain it confidently 👇

        ✅ 1. What is the Question?

        You are given two rectangles in a 2D Cartesian plane.

        Each rectangle is defined using:

        Top-left point (x₁, y₁)
        Bottom-right point (x₂, y₂)

        👉 You must:

        Return true if the rectangles overlap (intersect or touch), otherwise false.

        🔍 Example
        Rectangle 1: (left=0, top=10), (right=10, bottom=0)
        Rectangle 2: (left=5, top=5), (right=15, bottom=-5)

        → They overlap → true
        ✅ 2. Key Clarifications (Important in Interview 🔥)

        Before solving, always confirm:

        ✔️ Rectangles are axis-aligned (no rotation)
        ✔️ Coordinates follow standard Cartesian system:
        Left → smaller x
        Right → larger x
        Top → larger y
        Bottom → smaller y
        ✔️ Touching edges counts as overlap (usually YES unless specified)
        ✅ 3. Core Idea (Very Important 🚀)

        👉 Instead of checking overlap directly…

        💡 Check when they DO NOT overlap

        ❌ Non-Overlapping Cases

        Two rectangles do NOT overlap if:

        1. One is completely to the right
        r1.left > r2.right
        2. One is completely to the left
        r2.left > r1.right
        3. One is completely above
        r1.bottom > r2.top
        4. One is completely below
        r2.bottom > r1.top
        ✅ Final Logic

        👉 If ANY of the above is true → NO overlap
        👉 Otherwise → overlap exists

        ✅ 4. Algorithm (Step-by-Step)
        Check horizontal separation
        Check vertical separation
        If separated → return false
        Else → return true

        ✅ 6. Cleaner One-Line Version
        public static boolean isOverlap(Point r1lt, Point r1rb,
                                       Point r2lt, Point r2rb) {

            return !(r1lt.x > r2rb.x || r2lt.x > r1rb.x ||
                     r1rb.y > r2lt.y || r2rb.y > r1lt.y);
        }

        ✅ 7. Complexity Analysis
        Type	Complexity
        Time	O(1)
        Space	O(1)

        ✅ 8. Edge Cases 🚨
        Case	Result
        Touching edges	Usually true
        One inside another	true
        Same rectangle	true
        Completely separate	false

        ✅ 9. Common Interview Mistakes ❌
        ❌ Mixing up top/bottom coordinates
        ❌ Incorrect inequality signs (> vs >=)
        ❌ Trying to calculate area instead of logic
        ❌ Not clarifying coordinate system

        ✅ 10. Short Interview Answer (Perfect Summary)
            Two rectangles overlap unless one is completely to the left, right, above, or below the other.
            So we check these four conditions and return false if any is true.
     */
    public static void main(String[] args) {

        Point r1lt = new Point(1, 8);
        Point r1rb = new Point(5, 6);

        Point r2lt = new Point(3, 7);
        Point r2rb = new Point(6, 5);

        boolean result1 = Rectangles.overlap1(r1lt, r1rb, r2lt, r2rb);
        boolean result2 = Rectangles.overlap2(r1lt, r1rb, r2lt, r2rb);
        System.out.println("Result: " + result1 + "  |  " + result2);


        // chat gpt code.
        Point r1lt1 = new Point(0, 10);
        Point r1rb2 = new Point(10, 0);

        Point r2lt3 = new Point(5, 5);
        Point r2rb4 = new Point(15, -5);

        System.out.println(isOverlap(r1lt1, r1rb2, r2lt3, r2rb4)); // true
    }

    // chat gpt code.
    public static boolean isOverlap(Point r1lt, Point r1rb,
                                    Point r2lt, Point r2rb) {

        // Case 1 & 2: One rectangle is left/right of the other
        if (r1lt.x > r2rb.x || r2lt.x > r1rb.x) {
            return false;
        }

        // Case 3 & 4: One rectangle is above/below the other
        if (r1rb.y > r2lt.y || r2rb.y > r1lt.y) {
            return false;
        }

        return true;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

