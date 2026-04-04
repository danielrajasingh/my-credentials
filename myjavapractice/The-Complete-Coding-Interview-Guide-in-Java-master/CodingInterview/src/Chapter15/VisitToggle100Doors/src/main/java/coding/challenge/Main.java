package Chapter15.VisitToggle100Doors.src.main.java.coding.challenge;

import java.util.Arrays;

public class Main {
/*
Great—this is a very important interview puzzle (often called the 100 Doors Problem). Let’s break it down step by step 👇

🧩 1. Problem Statement (What is the question?)

You are given:

100 doors, all initially closed
You make 100 passes (visits)
Rules:
On the 1st pass → toggle every door
On the 2nd pass → toggle every 2nd door (#2, #4, #6…)
On the 3rd pass → toggle every 3rd door (#3, #6, #9…)
…
On the 100th pass → toggle only door #100

👉 Toggle =

Closed → Open
Open → Closed
❓ Final Question:

👉 After all 100 passes, which doors remain open?

🧠 2. Clear Analysis
🔍 Key Observation

A door is toggled when its door number is divisible by the pass number

👉 Example: Door #12 is toggled on passes:

1, 2, 3, 4, 6, 12

These are the divisors of 12

⚠️ Important Insight
Each divisor = 1 toggle
So:
Even number of divisors → door ends CLOSED
Odd number of divisors → door ends OPEN
💡 Critical Trick

👉 Only perfect squares have an odd number of divisors

Example:
12 → divisors = (1,2,3,4,6,12) → 6 → ❌ closed
9 → divisors = (1,3,9) → 3 → ✅ open
🎯 Final Conclusion

👉 Doors that remain OPEN are:

1, 4, 9, 16, 25, 36, 49, 64, 81, 100

👉 These are perfect squares

⚙️ 3. Solution Approach
✅ Optimal Approach (Best Answer in Interview)

Instead of simulating all toggles:

Loop from 1 to √n
Print i * i
 */
    public static void main(String[] args) {

        int[] result = Doors.visitToggle();

        System.out.println("Result: " + Arrays.toString(result));



        // ✅ Approach 1: Optimal (O(√n)) ⭐ Recommended
        printOpenDoors(100);


        //🐢 Approach 2: Simulation (Your Given Code Style)
        //Time Complexity: O(n²)
        int[] result1 = visitToggle(100);

        for (int i = 0; i < result1.length; i++) {
            if (result1[i] == 1) {
                System.out.println("Door " + (i + 1) + " is OPEN");
            }
        }
    }



    public static void printOpenDoors(int n) {

        for (int i = 1; i * i <= n; i++) {
            System.out.println("Door " + (i * i) + " is OPEN");
        }
    }


    public static int[] visitToggle(int n) {

        int[] doors = new int[n]; // 0 = closed, 1 = open

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                doors[j - 1] = 1 - doors[j - 1]; // toggle
            }
        }

        return doors;
    }
}
