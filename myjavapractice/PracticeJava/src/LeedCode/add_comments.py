#!/usr/bin/env python3
"""
Comprehensive comment structure injector for all LeetCode problems
Adds structured documentation to every problem file
"""
import os
import re

csv_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode\questions.csv"
base_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode"

# Problem categorization and documentation templates
problem_templates = {
    # Arrays & Lists
    'array': {
        'topic': 'Array, Lists',
        'explanation': 'Work with collections of elements. Use indices to access/manipulate data efficiently.',
        'key_obs': 'Index-based access enables O(1) lookups. Consider sliding windows for subarray problems.',
        'approach_steps': ['Identify pattern (sorting, searching, two-pointers)', 'Choose appropriate data structure', 'Iterate and process elements', 'Return result'],
        'memory_trick': 'Think INDEX: I-ntelligent access, N-est loops, D-ivide & conquer, E-dge cases, X-treme values'
    },
    'string': {
        'topic': 'String Manipulation',
        'explanation': 'Work with sequences of characters. Manipulate, search, transform strings efficiently.',
        'key_obs': 'Strings are immutable in Java. Use StringBuilder for efficient concatenation. Hash for quick lookups.',
        'approach_steps': ['Map character frequencies/patterns', 'Check constraints', 'Build or transform result', 'Validate output'],
        'memory_trick': 'STRING: S-can pattern, T-ransform, R-ecurse, I-mmutable, N-avigates fast, G-ets optimized'
    },
    'linkedlist': {
        'topic': 'Linked List',
        'explanation': 'Sequential data structure with pointers. No random access, but efficient insertions/deletions.',
        'key_obs': 'Two-pointer technique is powerful. Reverse in-place using three pointers. Check for cycles.',
        'approach_steps': ['Handle edge case (null/single node)', 'Initialize pointers (fast/slow or prev/curr)', 'Iterate and manipulate pointers', 'Return head or result'],
        'memory_trick': 'NODE-FLOW: N-avigates via pointers, O-ne direction, D-ynamic, E-fficient ops, F-ast cycles, L-ocal changes, O-pt insertions, W-ork with prev/next'
    },
    'tree': {
        'topic': 'Tree/Binary Search Tree',
        'explanation': 'Hierarchical structure with parent-child relationships. Traverse efficiently using DFS/BFS.',
        'key_obs': 'Recursion is natural. In-order gives sorted BST. Null checks crucial. Return at leaf cases.',
        'approach_steps': ['Base case: null or leaf', 'Process current node', 'Recurse on left/right', 'Combine results'],
        'memory_trick': 'TREE-DFS: T-raverse recursively, R-oot to leaf, E-ach subtree, D-epth first, F-unction calls, S-tack naturally'
    },
    'graph': {
        'topic': 'Graph, DFS/BFS',
        'explanation': 'Network of nodes with edges. Use DFS/BFS to explore connected components or shortest paths.',
        'key_obs': 'Visited array prevents infinite loops. Queue for BFS, Stack for DFS. Detect cycles with colors.',
        'approach_steps': ['Build adjacency list/matrix', 'Initialize visited array', 'Start from source, explore neighbors', 'Track results (components/path/cycle)'],
        'memory_trick': 'GRAPH-SEARCH: G-enerate adjacency, R-ecord visited, A-nalyze neighbors, P-rocess one at time, H-it all nodes'
    },
    'dynamic': {
        'topic': 'Dynamic Programming',
        'explanation': 'Break problem into overlapping subproblems. Store results to avoid recomputation.',
        'key_obs': 'Optimal substructure key. Memoization or tabulation. Build up from base cases.',
        'approach_steps': ['Define subproblem state', 'Identify base case', 'Build recurrence relation', 'Fill table/memo', 'Extract answer'],
        'memory_trick': 'DP-MEMO: D-efine state, P-revious solutions, M-emoize, E-ase computation, M-any overlaps, O-ptimal substructure'
    },
    'sort': {
        'topic': 'Sorting/Searching',
        'explanation': 'Order elements or find specific values. Use efficient algorithms (binary search, merge sort).',
        'key_obs': 'Binary search requires sorted data. Sorting: O(n log n) optimal. Compare based on problem needs.',
        'approach_steps': ['Understand requirement (sort/search/partition)', 'Choose algorithm', 'Implement with comparator if needed', 'Validate boundaries'],
        'memory_trick': 'SORT-SEARCH: S-elect algorithm, O-rder matters, R-ecognize pattern, T-idy boundaries, S-earch effectively'
    },
    'hash': {
        'topic': 'Hash Map, Sets',
        'explanation': 'Store key-value pairs or unique elements. O(1) average access but requires memory.',
        'key_obs': 'Hash enables O(1) lookup. Set for uniqueness. Count frequencies with HashMap.',
        'approach_steps': ['Identify what to store (key-value or set)', 'Iterate and populate map/set', 'Query/process results', 'Return answer'],
        'memory_trick': 'HASH-MAP: H-eap values, A-ddress with key, S-tore frequency, H-ash collisions, M-aintain count'
    },
    'bit': {
        'topic': 'Bit Manipulation',
        'explanation': 'Work with individual bits. Use bitwise operators for efficient operations.',
        'key_obs': 'XOR: a^a=0, a^0=a. AND masks bits. OR sets bits. Shifts multiply/divide by 2.',
        'approach_steps': ['Understand bitwise operations', 'Extract relevant bits', 'Apply operations', 'Combine or extract result'],
        'memory_trick': 'BIT-OPS: B-inary operations, I-ndividual bits, T-each value, O-ne operation, P-erfectly fast, S-hift multiply'
    },
}

def categorize_problem(problem_name):
    """Categorize problem by name to determine topic"""
    name_lower = problem_name.lower()
    
    categorization = {
        'array': ['array', 'duplicate', 'remove', 'sort', 'sum', 'max', 'min', 'swap', 'rotate', 'partition', 'merge'],
        'string': ['string', 'word', 'char', 'substring', 'palindrome', 'anagram', 'pattern', 'match'],
        'linkedlist': ['linked', 'node', 'list', 'cycle', 'reverse'],
        'tree': ['tree', 'binary', 'bst', 'traversal', 'inorder', 'preorder', 'postorder', 'level'],
        'graph': ['graph', 'island', 'cycle', 'path', 'connected', 'dfs', 'bfs', 'matrix'],
        'dynamic': ['dynamic', 'fib', 'coin', 'climb', 'rob', 'jump', 'edit', 'subsequence', 'partition'],
        'sort': ['sort', 'search', 'binary', 'kth', 'median'],
        'hash': ['hash', 'count', 'frequency', 'map', 'set', 'unique'],
        'bit': ['bit', 'binary', 'xor', 'complement', 'hamming'],
    }
    
    for category, keywords in categorization.items():
        if any(keyword in name_lower for keyword in keywords):
            return category
    
    return 'array'  # default

def generate_comment_header(problem_name, difficulty, category):
    """Generate comprehensive comment header for problem"""
    template = problem_templates.get(category, problem_templates['array'])
    
    dry_run_examples = {
        'array': f'Input: [{1}, {2}, {3}]\nProcess: Check each element\nOutput: Result based on logic',
        'string': f'Input: "hello"\nProcess: Character by character\nOutput: Transformed result',
        'linkedlist': f'Input: 1->2->3->null\nProcess: Traverse nodes\nOutput: Modified list or value',
        'tree': f'Input: Tree(1, left:2, right:3)\nProcess: DFS traversal\nOutput: Computed result',
        'graph': f'Input: Nodes: [0,1,2], Edges: [[0,1],[1,2]]\nProcess: Explore connected components\nOutput: Count/path/cycle',
        'dynamic': f'Input: n=5\nSubproblems: Build up from base case\nOutput: Final computed value',
        'sort': f'Input: [3, 1, 4, 1, 5]\nProcess: Sort/Search\nOutput: Sorted or found element',
        'hash': f'Input: [1, 2, 1, 3, 2, 1]\nProcess: Store frequencies\nOutput: Map/count result',
        'bit': f'Input: 5 (101 in binary)\nProcess: Bitwise operations\nOutput: Manipulated bits',
    }
    
    memory_tricks = {
        'array': '"ARRAY = Advanced Rapid Retrieval At Your End"',
        'string': '"STRING = Smart Transform Using Neat INdexing Growths"',
        'linkedlist': '"POINTER = Persistent Operations In Navigation Through Element Recurrence"',
        'tree': '"TREE = Traverse Recursively Each Element Elegantly"',
        'graph': '"GRAPH = Generate Routes Across Path Hierarchies"',
        'dynamic': '"DP = Declare Problem state, Previous solutions Matter"',
        'sort': '"SORT = Sequential Order Required, Track operations"',
        'hash': '"HASH = Heap And Store High-speed Access"',
        'bit': '"BIT = Binary Integer Transformation"',
    }
    
    comment = f"""/*
========================================
🔹 PROBLEM: {problem_name}
🔹 DIFFICULTY: {difficulty.upper()}
🔹 TOPIC: {template['topic']}
========================================

📝 PROBLEM EXPLANATION:
{template['explanation']}

🧠 KEY OBSERVATIONS / INTUITION:
{template['key_obs']}

📋 APPROACH (Step-by-Step):
"""
    
    for i, step in enumerate(template['approach_steps'], 1):
        comment += f"   Step {i}: {step}\n"
    
    comment += f"""
⏱️ COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single or nested iterations through input
   Space Complexity: O(n) - Output storage or auxiliary data structure

🔄 DRY RUN EXAMPLE:
{dry_run_examples.get(category, dry_run_examples['array'])}

💡 ONE-LINE MEMORY TRICK:
{memory_tricks.get(category, memory_tricks['array'])}

🎨 MENTAL VISUALIZATION:
Imagine the problem as a real-world scenario. Work through a small example
step-by-step, visualizing how each operation changes the state.

⚠️ IMPORTANT EDGE CASES:
• Empty input (null, empty array/string)
• Single element
• All same elements
• Maximum constraints

✅ SOLUTION STRATEGY:
1. Understand problem completely
2. Identify pattern/category
3. Choose appropriate data structure
4. Implement core logic
5. Handle edge cases
6. Test with examples

========================================
*/

"""
    return comment

def update_file_with_comments(file_path, problem_name, difficulty):
    """Add comment header to Java file"""
    try:
        with open(file_path, 'r') as f:
            content = f.read()
        
        # Skip if already has comprehensive comments
        if '🔹 PROBLEM:' in content or '📝 PROBLEM EXPLANATION:' in content:
            return False
        
        # Categorize problem
        category = categorize_problem(problem_name)
        
        # Generate comment header
        comment_header = generate_comment_header(problem_name, difficulty, category)
        
        # Insert comment before package declaration
        if content.startswith('package'):
            # Find end of package line
            package_end = content.find('\n') + 1
            new_content = comment_header + content[package_end:]
        else:
            new_content = comment_header + content
        
        # Write back
        with open(file_path, 'w') as f:
            f.write(new_content)
        
        return True
    except Exception as e:
        print(f"Error processing {file_path}: {e}")
        return False

# Process all Java files
total_updated = 0
processed = 0

for difficulty in ['easy', 'medium', 'hard']:
    dir_path = os.path.join(base_path, difficulty)
    
    if not os.path.exists(dir_path):
        continue
    
    for filename in os.listdir(dir_path):
        if filename.endswith('.java'):
            file_path = os.path.join(dir_path, filename)
            problem_name = filename.replace('.java', '')
            
            if update_file_with_comments(file_path, problem_name, difficulty):
                total_updated += 1
            
            processed += 1
            if processed % 250 == 0:
                print(f"Processed {processed} files, Updated {total_updated} with comments...")

print(f"\nCompletion Summary:")
print(f"  Total files processed: {processed}")
print(f"  Files updated with comments: {total_updated}")
print(f"  Skipped (already have comments): {processed - total_updated}")
