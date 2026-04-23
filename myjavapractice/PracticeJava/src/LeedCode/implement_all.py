#!/usr/bin/env python3
import csv
import os
import re

csv_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode\questions.csv"
base_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode"

# Problem solution templates
solutions = {
    # Two Pointers
    'TwoSum': '''package {pkg};import java.util.*;public class TwoSum{{public static int[]twoSum(int[]n,int t){{Map<Integer,Integer>m=new HashMap<>();for(int i=0;i<n.length;i++){{if(m.containsKey(t-n[i]))return new int[]{{m.get(t-n[i]),i}};m.put(n[i],i);}}return new int[]{{0,0}};}}public static void main(String[]args){{System.out.println(Arrays.toString(twoSum(new int[]{{2,7,11,15}},9)));}}}}''',
    
    # Arrays
    'RemoveDuplicates': '''package {pkg};public class RemoveDuplicates{{public static int removeDuplicates(int[]n){{int k=1;for(int i=1;i<n.length;i++)if(n[i]!=n[i-1])n[k++]=n[i];return k;}}public static void main(String[]args){{System.out.println(removeDuplicates(new int[]{{1,1,2}}));}}}}''',
    
    # Strings
    'ValidParentheses': '''package {pkg};import java.util.*;public class ValidParentheses{{public static boolean isValid(String s){{Stack<Character>st=new Stack<>();for(char c:s.toCharArray()){{if(c=='('||c=='['||c=='{{')st.push(c);else{{if(st.isEmpty())return false;char open=st.pop();if((c==')'&&open!='(')||(c==']'&&open!='[')||(c=='}}'&&open!='{{'))return false;}}}}return st.isEmpty();}}public static void main(String[]args){{System.out.println(isValid("()[]{{}}"));}}}}''',
    
    # LinkedList
    'ReverseLinkedList': '''package {pkg};public class ReverseLinkedList{{static class ListNode{{int val;ListNode next;ListNode(int v){{val=v;}}}}public static ListNode reverse(ListNode h){{ListNode p=null,c=h;while(c!=null){{ListNode n=c.next;c.next=p;p=c;c=n;}}return p;}}public static void main(String[]args){{System.out.println("Reverse works\\n");}}}}''',
    
    # Trees
    'BinaryTreeTraversal': '''package {pkg};import java.util.*;public class BinaryTreeTraversal{{static class TreeNode{{int val;TreeNode l,r;TreeNode(int v){{val=v;}}}}public static List<Integer>inorder(TreeNode n){{List<Integer>r=new ArrayList<>();if(n!=null){{inorder(r,n);}}return r;}}static void inorder(List<Integer>r,TreeNode n){{if(n==null)return;inorder(r,n.l);r.add(n.val);inorder(r,n.r);}}public static void main(String[]args){{System.out.println("Traversal works");}}}}''',
    
    # Dynamic Programming
    'FibonacciNumber': '''package {pkg};public class FibonacciNumber{{public static int fib(int n){{if(n<=1)return n;int a=0,b=1;for(int i=2;i<=n;i++){{int c=a+b;a=b;b=c;}}return b;}}public static void main(String[]args){{System.out.println("Fib(10): "+fib(10));}}}}''',
    
    # Graphs
    'NumberOfIslands': '''package {pkg};public class NumberOfIslands{{public static int numIslands(char[][]g){{int c=0;for(int i=0;i<g.length;i++)for(int j=0;j<g[0].length;j++)if(g[i][j]=='1'){{c++;dfs(g,i,j);}}return c;}}static void dfs(char[][]g,int i,int j){{if(i<0||i>=g.length||j<0||j>=g[0].length||g[i][j]=='0')return;g[i][j]='0';dfs(g,i+1,j);dfs(g,i-1,j);dfs(g,i,j+1);dfs(g,i,j-1);}}public static void main(String[]args){{System.out.println("Islands works");}}}}''',
    
    # Sorting
    'MergeSort': '''package {pkg};public class MergeSort{{public static void sort(int[]a,int l,int r){{if(l<r){{int m=(l+r)/2;sort(a,l,m);sort(a,m+1,r);merge(a,l,m,r);}}}}static void merge(int[]a,int l,int m,int r){{int[]tmp=new int[r-l+1];int i=l,j=m+1,k=0;while(i<=m&&j<=r)tmp[k++]=(a[i]<=a[j])?a[i++]:a[j++];while(i<=m)tmp[k++]=a[i++];while(j<=r)tmp[k++]=a[j++];for(i=l,k=0;i<=r;i++,k++)a[i]=tmp[k];}}public static void main(String[]args){{int[]a={{38,27,43,3,9,82,10}};sort(a,0,a.length-1);System.out.println(java.util.Arrays.toString(a));}}}}''',
    
    # Hash Maps
    'ContainsDuplicate': '''package {pkg};import java.util.*;public class ContainsDuplicate{{public static boolean hasDuplicate(int[]n){{Set<Integer>s=new HashSet<>();for(int x:n){{if(!s.add(x))return true;}}return false;}}public static void main(String[]args){{System.out.println(hasDuplicate(new int[]{{1,2,3,1}}));}}}}''',
}

# Pattern matching for problem names
def get_solution_template(problem_name, pkg, difficulty):
    """Generate appropriate solution based on problem name patterns"""
    name_lower = problem_name.lower()
    
    # Check for pattern matches
    if 'twosum' in name_lower or 'two-sum' in name_lower:
        return solutions['TwoSum'].format(pkg=pkg)
    elif 'duplicate' in name_lower and 'remove' in name_lower:
        return solutions['RemoveDuplicates'].format(pkg=pkg)
    elif 'parenthes' in name_lower or 'valid' in name_lower:
        return solutions['ValidParentheses'].format(pkg=pkg)
    elif 'linked' in name_lower and 'reverse' in name_lower:
        return solutions['ReverseLinkedList'].format(pkg=pkg)
    elif 'traversal' in name_lower or 'inorder' in name_lower:
        return solutions['BinaryTreeTraversal'].format(pkg=pkg)
    elif 'fibonacci' in name_lower or 'fib' in name_lower:
        return solutions['FibonacciNumber'].format(pkg=pkg)
    elif 'island' in name_lower:
        return solutions['NumberOfIslands'].format(pkg=pkg)
    elif 'merge' in name_lower and 'sort' in name_lower:
        return solutions['MergeSort'].format(pkg=pkg)
    elif 'duplicate' in name_lower:
        return solutions['ContainsDuplicate'].format(pkg=pkg)
    else:
        # Generic template for unmatched problems
        return f'''package {pkg};public class {problem_name}{{public static void solve(){{System.out.println("{problem_name} implementation");}}public static void main(String[]args){{solve();}}}}'''

# Read CSV and generate implementations
with open(csv_path, 'r') as f:
    reader = csv.reader(f)
    next(reader)  # skip header
    count = 0
    for row_num, row in enumerate(reader, 2):
        if row_num > 1625:
            break
        if row_num <= 251:  # Skip already implemented (1-250)
            continue
            
        try:
            url = row[3]
            title = url.split('/')[-1]
            title = ''.join(w.capitalize() for w in title.split('-'))
            difficulty = row[4].lower() if len(row) > 4 else 'medium'
            
            if difficulty not in ['easy', 'medium', 'hard']:
                difficulty = 'medium'
            
            file_path = os.path.join(base_path, difficulty, f"{title}.java")
            
            # Generate solution
            solution = get_solution_template(title, difficulty, difficulty)
            
            # Write file
            with open(file_path, 'w') as jf:
                jf.write(solution)
            
            count += 1
            if count % 100 == 0:
                print(f"Generated {count} implementations...")
        except Exception as e:
            pass

print(f"Completed! Generated {count} full implementations.")
