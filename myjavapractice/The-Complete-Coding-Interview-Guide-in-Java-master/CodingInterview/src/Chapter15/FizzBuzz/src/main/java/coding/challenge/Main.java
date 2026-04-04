package Chapter15.FizzBuzz.src.main.java.coding.challenge;
/*
🧩 1. Problem Statement (What is the question?)

You are given a positive integer n.

Print numbers from 1 to n, but with these rules:

If a number is divisible by 5, print "fizz"
If a number is divisible by 7, print "buzz"
If a number is divisible by both 5 and 7, print "fizzbuzz"
Otherwise, print the number itself

👉 Each output should be on a new line

🧠 2. Clear Analysis
Key Concept

We need to check divisibility using:

i % number == 0
Important Logic Order (VERY IMPORTANT)

You must check:

Divisible by both 5 and 7 first
Then check only 5
Then check only 7
Else print number

❗ Why?
If you check 5 first, then 35 will print "fizz" instead of "fizzbuzz"

Example (n = 15)
1 → 1
5 → fizz
7 → buzz
10 → fizz
14 → buzz
15 → fizz

Example (n = 35):

35 → fizzbuzz
⚙️ 3. Solution Approach
Step-by-step
Loop from 1 to n
For each number:
Check if divisible by both → print "fizzbuzz"
Else if divisible by 5 → print "fizz"
Else if divisible by 7 → print "buzz"
Else → print number
 */
public class Main {

    public static void main(String[] args) {

        FizzBuzz.print(100);

        // clean code.
        printFizzBuzz(100);
    }




    //✅ Simple & Clean Version
    public static void printFizzBuzz(int n) {

        for (int i = 1; i <= n; i++) {

            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.println("fizz");
            } else if (i % 7 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
