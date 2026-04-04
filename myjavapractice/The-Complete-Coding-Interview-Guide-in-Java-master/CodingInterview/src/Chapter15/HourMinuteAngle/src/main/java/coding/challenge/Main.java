package Chapter15.HourMinuteAngle.src.main.java.coding.challenge;
 
public class Main {
/*
Great—this is a formula-based problem (very common in interviews). Let’s break it down clearly 👇

🧩 1. Problem Statement (What is the question?)

You are given a time in hour:minute (h:m) format.

👉 Task:
Find the smaller angle between:

Hour hand
Minute hand

on an analog clock

📌 Example
Input: 10:10
Output: 115°
🧠 2. Clear Analysis
🔍 Key Observations
⏱ Clock Basics
Full circle = 360°
12 hours → each hour =
360 / 12 = 30°
🕒 Hour Hand Movement
Moves 30° per hour
Also moves 0.5° per minute

👉 Formula:

Hour angle = (hour × 30) + (minute × 0.5)
🕓 Minute Hand Movement
Moves 6° per minute

👉 Formula:

Minute angle = minute × 6
🎯 Final Angle Formula

👉 Difference between hands:

angle = |Hour angle - Minute angle|

👉 But we need smaller angle:

if angle > 180 → 360 - angle
⚙️ 3. Solution Approach
Steps:
Calculate hour hand angle
Calculate minute hand angle
Find absolute difference
If > 180 → subtract from 360
🧠 Example Walkthrough
🕒 Time: 10:10

Hour hand:

10 × 30 + 10 × 0.5 = 300 + 5 = 305°

Minute hand:

10 × 6 = 60°

Difference:

|305 - 60| = 245°

Final:

360 - 245 = 115°


📊 5. Complexity Analysis
Time Complexity: O(1)
Space Complexity: O(1)

👉 Pure mathematical calculation

🎯 6. Interview Key Points
✅ You should say:
“Hour hand moves continuously (not step-wise)”
“Minute hand moves 6° per minute”
“We compute absolute difference and take smaller angle”
⚠️ Common Mistakes
Ignoring minute contribution to hour hand ❌
Not taking smaller angle ❌
Not handling 12 correctly ❌
🚀 7. Pro Insight

👉 This is a formula + edge-case problem, not algorithm-heavy.

👉 Interviewer checks:

Mathematical reasoning
Attention to detail
🧠 Bonus

👉 Shortcut formula (combined):

angle = |(30 × hour) - (5.5 × minute)|

Then:

result = min(angle, 360 - angle)
 */
    public static void main(String[] args) {

        float clock1 = Clock.findAngle(10, 10);
        float clock2 = Clock.findAngle(9, 40);
        float clock3 = Clock.findAngle(4, 40);
        
        float clock4 = Clock.findAngle(12, 1);
        float clock5 = Clock.findAngle(4, 19);
        
        System.out.println("10:10 has an angle of " + clock1 + " degrees");
        System.out.println("9:40 has an angle of " + clock2 + " degrees");
        System.out.println("4:40 has an angle of " + clock3 + " degrees");        
        System.out.println("12:01 has an angle of " + clock4 + " degrees");        
        System.out.println("4:19 has an angle of " + clock5 + " degrees");




        // ✅ Clean Code
        System.out.println(findAngle(10, 10)); // 115°
        System.out.println(findAngle(9, 40));  // 50°
        System.out.println(findAngle(4, 40));  // 100°
    }




    public static float findAngle(int hour, int minute) {

        // Validate input
        if (hour < 1 || hour > 12 || minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Invalid time");
        }

        // Convert 12 to 0 for calculation
        if (hour == 12) {
            hour = 0;
        }

        // Hour hand angle
        float hourAngle = (hour * 30) + (minute * 0.5f);

        // Minute hand angle
        float minuteAngle = minute * 6;

        // Find difference
        float angle = Math.abs(hourAngle - minuteAngle);

        // Return smaller angle
        return Math.min(angle, 360 - angle);
    }
}
