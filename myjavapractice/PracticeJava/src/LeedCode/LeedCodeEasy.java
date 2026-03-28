package LeedCode;

import java.util.*;

public class LeedCodeEasy {
    // Start
    public static void main(String[] args){
        uniqueEmailAddresses(); // calling method
        checkRotateString();
        solveSetMismatch();
        solveSumRootToLeaf();
        solveNextGreaterElement();
        stackUsingQueue();
        executeRangeSumQueryUsingPrefixSum();
    }
    // Problem: Unique Email Addresses
    public static void uniqueEmailAddresses() {

        /*
         * Question: Unique Email Addresses
         *
         * You are given an array of strings 'emails' where each string represents an email address.
         *
         * An email address has the format:
         *      local_name@domain_name
         *
         * Rules to process the emails:
         * 1. In the local name (before @):
         *    - Ignore all '.' characters.
         *    - Ignore any characters after a '+' sign (including the '+' itself).
         * 2. The domain name (after @) remains unchanged.
         *
         * After processing all emails according to these rules,
         * count how many unique email addresses remain.
         *
         * Example:
         * Input:
         * ["test.email+alex@leetcode.com",
         *  "test.e.mail+bob.cathy@leetcode.com",
         *  "testemail+david@lee.tcode.com"]
         *
         * Processing:
         * testemail@leetcode.com
         * testemail@leetcode.com
         * testemail@lee.tcode.com
         *
         * Output:
         * 2
         *
         * In short:
         * Given a list of emails, normalize them by ignoring dots and everything after '+' in the local name,
         * then return the number of distinct email addresses.
         */

        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };

        Set<String> set = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // remove '+' part
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // remove dots
            local = local.replace(".", "");

            String cleanEmail = local + "@" + domain;

            set.add(cleanEmail);
        }

        System.out.println("Unique Email Count: " + set.size());
        System.out.println("unique emails are:"+set);
    }

    public static void checkRotateString() {
        /*Here’s a structured breakdown for the Rotate String problem from LeetCode:


        Question:
        Given two strings s and goal, return true if you can rotate s any number of times to get goal.
        Rotation means moving the first character of s to the end.

        Example:
        Input: s = "abcde", goal = "cdeab"
        Output: true

        Analysis:
        - A rotation preserves the order of characters but shifts them circularly.
        - For s to match goal after rotation, goal must be a substring of s+s.
        - If lengths differ, return false immediately.

        Solution Steps:
        1. Check if lengths of s and goal are equal.
        2. Concatenate s with itself to form s+s.
        3. Check if goal is a substring of s+s.
        4. Return true if it is, false otherwise.

        Hints / Notes / Keep Remember:
        - Using s+s is a common trick to check for all rotations.
        - Always check lengths first to avoid unnecessary computation.
        - Time complexity: O(n), Space complexity: O(n).
        */
        String s = "waterbottle";
        String goal = "erbottlewat";

        // Check if lengths are equal
        if (s.length() != goal.length()) {
            System.out.println("The strings have different lengths, so rotation is not possible.");
        } else {
            String doubled = s + s;
            if (doubled.contains(goal)) {
                System.out.println("Yes! \"" + goal + "\" is a rotation of \"" + s + "\".");
            } else {
                System.out.println("No! \"" + goal + "\" is NOT a rotation of \"" + s + "\".");
            }
        }
    }

    public static void solveSetMismatch() {
            /*

                Here’s a structured breakdown for the Set Mismatch problem from LeetCode:

                Question:
                You are given an array nums representing numbers from 1 to n.
                One number is duplicated and one number is missing. Find them.
                Return an array where the first element is the duplicated number and the second is the missing number.

                Example:
                Input: nums = [1,2,2,4]
                Output: [2,3]

                Analysis:
                - The array should contain numbers 1..n with no duplicates.
                - Due to the duplicate, one number appears twice, and one number is missing.
                - Need to detect both numbers efficiently.

                Solution Steps:
                1. Use a HashSet to track numbers we have seen.
                2. Iterate through nums:
                   - If a number is already in the set, it is the duplicate.
                   - Otherwise, add it to the set.
                3. After first pass, check which number from 1..n is not in the set → that's the missing number.
                4. Return [duplicate, missing].

                Hints / Notes / Keep Remember:
                - Time complexity: O(n)
                - Space complexity: O(n) with HashSet.
                - Alternative approaches: Use index mapping or XOR to reduce space complexity.
                - Be careful to handle both duplicate and missing correctly.
        */

        int[] nums = {1, 2, 2, 4};
        Set<Integer> seen = new HashSet<>();
        int duplicate = -1;
        int missing = -1;
        int n = nums.length;

        // Find duplicate
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num;
            } else {
                seen.add(num);
            }
        }

        // Find missing
        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }

        System.out.println("Duplicate number: " + duplicate);
        System.out.println("Missing number: " + missing);
        System.out.println("Result array: [" + duplicate + ", " + missing + "]");
    }


    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Main solving method (no parameter, void)
    public static void solveSumRootToLeaf() {

        /*
                Constructing Tree:
                        1
                       / \
                      0   1
                     / \   \
                    0   1   1
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        int result = dfs(root, 0);

        System.out.println("Sum of all root-to-leaf binary numbers: " + result);
    }

    // DFS helper method
    public static int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        // Build binary number
        current = current * 2 + node.val;

        // If leaf node
        if (node.left == null && node.right == null) {
            return current;
        }

        // Sum of left and right
        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static void solveNextGreaterElement() {
        /*
            Question:
            You are given two arrays nums1 and nums2 where nums1 is a subset of nums2.

            For each element in nums1, find the next greater element in nums2.
            The next greater element is the first element to the right in nums2 that is greater than it.
            If no such element exists, return -1.

            Example:
            Input:
            nums1 = [4,1,2]
            nums2 = [1,3,4,2]

            Output:
            [-1,3,-1]

            Explanation:
            - For 4 → no greater element → -1
            - For 1 → next greater is 3
            - For 2 → no greater element → -1

            --------------------------------------------------

            Analysis:
            - Brute force: For each element in nums1, scan nums2 → O(n^2)
            - Optimized: Use Stack + HashMap
            - Idea:
              Traverse nums2 and build a map of each number → its next greater element.

            --------------------------------------------------

            Solution Steps:
            1. Create a HashMap<Integer, Integer> to store next greater elements.
            2. Use a Stack to process nums2.
            3. Traverse nums2:
               - While stack is not empty AND current element > stack.peek():
                   → pop from stack and map it to current element.
               - Push current element to stack.
            4. For remaining stack elements → no greater element → map them to -1.
            5. For each element in nums1 → fetch result from map.

            --------------------------------------------------

            Hints / Notes / Keep Remember:
            - Stack helps track decreasing sequence.
            - We solve nums2 first, then answer nums1 easily.
            - This is a "Monotonic Stack" problem.
            - Time Complexity: O(n)
            - Space Complexity: O(n)
        */
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Build next greater map using nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Remaining elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Prepare result for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        // Print result
        System.out.println("Next Greater Elements:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(nums1[i] + " -> " + result[i]);
        }
    }


    public static void stackUsingQueue() {
        /*
                    Question:
                    Implement a stack using queues. The stack should support standard operations:
                    - push(x): Push element x onto stack
                    - pop(): Removes the element on top of the stack
                    - top(): Get the top element
                    - empty(): Returns whether the stack is empty

                    Note:
                    You must use only standard queue operations:
                    (add, remove/poll, peek, size, isEmpty)

                    --------------------------------------------------

                    Analysis:
                    - Stack follows LIFO (Last In First Out)
                    - Queue follows FIFO (First In First Out)

                    So we need to simulate LIFO using FIFO.

                    Idea:
                    - Use one queue
                    - When pushing, rearrange elements so newest stays at front

                    --------------------------------------------------

                    Solution Steps (Using One Queue):
                    1. Create a queue
                    2. push(x):
                       - Add element to queue
                       - Rotate the queue (move previous elements to back)
                    3. pop():
                       - Remove from front of queue
                    4. top():
                       - Peek front element
                    5. empty():
                       - Check if queue is empty

                    --------------------------------------------------

                    Hint:
                    - After every push, make sure the newly added element is always at the front
                    - Use loop: size-1 times poll and add

                    --------------------------------------------------

                    Notes:
                    - This approach makes push costly (O(n))
                    - pop() becomes O(1)
                    - Alternative approach exists where pop is costly

                    --------------------------------------------------

                    Keep Remember:
                    - Queue → FIFO
                    - Stack → LIFO
                    - Trick is reordering elements after insertion
        */
        Queue<Integer> queue = new LinkedList<>();

        // push operation
        System.out.println("Push operations:");
        push(queue, 10);
        push(queue, 20);
        push(queue, 30);

        System.out.println("Current Queue (Top at front): " + queue);

        // top operation
        System.out.println("Top element: " + queue.peek());

        // pop operation
        System.out.println("Pop element: " + queue.poll());

        System.out.println("After pop, Queue: " + queue);

        // empty check
        System.out.println("Is stack empty? " + queue.isEmpty());
    }

    // push helper
    public static void push(Queue<Integer> queue, int x) {
        queue.add(x);

        int size = queue.size();

        // rotate elements
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }

        System.out.println("Pushed: " + x);
    }



    // Meaningful method name
    public static void executeRangeSumQueryUsingPrefixSum() {
        /*
        QUESTION:
        Given an integer array nums, we need to answer multiple queries:
        sumRange(left, right) → sum of elements from left to right (inclusive).
        Array is immutable (no updates).

        ANALYSIS:
        Brute force → iterate every time → O(n) per query.
        Not efficient when queries are many.

        We optimize using PREFIX SUM.

        SOLUTION STEPS:
        1. Create prefix sum array:
           prefix[i] = sum of elements from index 0 to i-1

        2. Build prefix array:
           prefix[i+1] = prefix[i] + nums[i]

        3. Query formula:
           sumRange(left, right) = prefix[right+1] - prefix[left]

        HINT:
        Precompute once → reuse for all queries.

        NOTES:
        - Prefix sum avoids repeated calculation
        - Works best when array is immutable
        - Common pattern in range queries

        KEEP REMEMBER:
        - Prefix array size = n + 1
        - Always use (right + 1)
        - Query becomes O(1)
        */
        int[] nums = {-2, 0, 3, -5, 2, -1};

        // Step 1: Create prefix array
        int[] prefix = new int[nums.length + 1];

        // Step 2: Build prefix sum
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 3: Perform queries
        int result1 = prefix[2 + 1] - prefix[0]; // sumRange(0,2)
        int result2 = prefix[5 + 1] - prefix[2]; // sumRange(2,5)
        int result3 = prefix[5 + 1] - prefix[0]; // sumRange(0,5)

        // Output
        System.out.println("sumRange(0,2) = " + result1);
        System.out.println("sumRange(2,5) = " + result2);
        System.out.println("sumRange(0,5) = " + result3);
    }

// End
}
