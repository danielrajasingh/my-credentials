package Chapter15.ScheduleOneElevator.src.main.java.coding.challenge;
import java.util.Arrays;
import java.util.Collections;
public class Main {
/*
            🧩 1. Problem Statement (What is the question?)

            You are given:

            An array floors[] → destination floors of n people
            Elevator capacity k (max people per trip)
            All start at ground floor (0)
            Elevator takes 1 unit time per floor (up or down)

            👉 Goal:
            Schedule elevator trips such that:

            All people reach their destination
            Elevator returns to ground after each trip
            Total time is minimized
            📌 Example
            floors = [4, 2, 1, 2, 4]
            k = 3

            👉 Output:

            Minimum time = 12
            🧠 2. Clear Analysis
            🔍 Key Insight

            👉 To minimize time:

            Always take people going to highest floors first

            Why?

            Elevator travel cost depends on highest floor in the trip
            Lower floors can be handled “on the way”
            💡 Important Observation

            For each trip:

            Time = 2 × (highest floor in that group)

            👉 Because:

            Go up → max floor
            Come down → max floor
            🧠 Strategy
            Sort floors in descending order
            Group people into batches of size k
            For each group:
            Only the first (largest) floor matters
            Add 2 × that floor to total time
            📊 Example Walkthrough
            floors = [4, 2, 1, 2, 4]
            Step 1: Sort descending
            [4, 4, 2, 2, 1]
            Step 2: Group by k = 3
            Group 1: [4, 4, 2]
            Group 2: [2, 1]
            Step 3: Calculate time
            Group 1 → 2 × 4 = 8
            Group 2 → 2 × 2 = 4
            ✅ Total:
            8 + 4 = 12
            ⚙️ 3. Solution Approach (Greedy)
            Steps:
            Sort array in descending order
            Loop with step k
            Add 2 × floors[i] to total time


📊 5. Complexity Analysis
Step	Complexity
Sorting	O(n log n)
Loop	O(n)
Total	O(n log n)
 */
    public static void main(String[] args) {

        int k = 3;
        int floors[] = {4, 2, 1, 2, 4};
        
        System.out.println("Minimum time: " + Elevators.time(k, floors));

//✅ Clean & Optimal Code
        int[] floors1 = {4, 2, 1, 2, 4};
        int k1 = 3;

        System.out.println("Minimum time: " + minTime(floors1, k1));
    }



    public static int minTime(int[] floors, int k) {

        // Convert to Integer[] for reverse sorting
        Integer[] arr = Arrays.stream(floors).boxed().toArray(Integer[]::new);

        // Sort in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        int time = 0;

        // Process in groups of k
        for (int i = 0; i < arr.length; i += k) {
            time += 2 * arr[i]; // highest floor in group
        }

        return time;
    }
}
