#!/usr/bin/env python3
import csv
import os

# Read CSV
csv_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode\questions.csv"
base_path = r"c:\Users\danie\Downloads\myintpre\my-credentials\myjavapractice\PracticeJava\src\LeedCode"

problems_map = {
    'easy': [], 'medium': [], 'hard': []
}

with open(csv_path, 'r') as f:
    reader = csv.reader(f)
    next(reader)  # skip header
    for row_num, row in enumerate(reader, 2):
        if row_num > 1625:  # Only 1625 rows total
            break
        try:
            title = row[3].split('/')[-1]  # Extract problem name from URL
            title = ''.join(w.capitalize() for w in title.split('-'))
            difficulty = row[4].lower()
            
            # Determine category
            if difficulty not in problems_map:
                difficulty = 'medium'
            
            problems_map[difficulty].append(title)
        except:
            pass

# Generate Java files
template = '''package {pkg};public class {name}{{public static void main(String[]args){{System.out.println("{name} works\\n");}}}}'''

for difficulty, problems in problems_map.items():
    dir_path = os.path.join(base_path, difficulty)
    os.makedirs(dir_path, exist_ok=True)
    
    for problem in problems:
        file_path = os.path.join(dir_path, f"{problem}.java")
        if not os.path.exists(file_path):
            content = template.format(pkg=difficulty, name=problem)
            with open(file_path, 'w') as f:
                f.write(content)
            print(f"Created: {file_path}")

print("Generation complete!")
