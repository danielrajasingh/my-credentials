package collections.arraylist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/*
🔥 Interview Tip:
    ✅ To reverse sorting using lambda, we swap the operands in compareTo, i.e., (a, b) -> b.compareTo(a).
    ✅ String::compareTo → ascending
    ✅ Comparator.reverseOrder() → descending
    ✅ Collections.sort(list);  uses Comparable internally - Alphabetical (lexicographical) - Comparable (Natural Ordering) - Comparator (Custom Ordering)
    ✅ When to use what? Use Comparable → default sorting ✅ Use Comparator → custom logic ✅ (most real-world cases)

    1️⃣ Strings:
        ✅ String::compareTo → ascending (natural order)
        ✅ (a, b) -> b.compareTo(a) → reverse sorting using lambda
        ✅ Comparator.reverseOrder() → descending order

    2️⃣ Dates:
       ✅ Date implements Comparable → natural order (ascending)
       ✅ Collections.sort(list) uses Comparable internally
       ✅ Collections.reverse(list) → reverse current order

    3️⃣ Employee / Department Objects:
       ✅ Implement Comparable<T> to define natural order (salary, budget)
           - Example: compareTo(Employee other) → salary ascending
           - Example: compareTo(Department other) → budget ascending
       ✅ Use Comparator for custom sorting:
           - Descending order
           - Multi-field sorting (e.g., salary/budget → name)
           - Fully reversed order
           - Example: Comparator.comparingDouble(...).thenComparing(...)

    4️⃣ When to use what:
       ✅ Comparable → default natural sorting, one per class
       ✅ Comparator → custom logic, multiple ways to sort, used in most real-world cases

    5️⃣ Lambda & Modern Java Tricks:
       ✅ Swap operands in lambda for reverse: (a, b) -> b.compareTo(a)
       ✅ Chaining with thenComparing() → multi-field sorting
       ✅ Collections.sort(list) internally uses Comparable if no Comparator provided
       ✅ Works for Strings, Dates, and custom objects like Employee/Department

    6️⃣ Key Takeaways:
       ✅ Comparable → natural order
       ✅ Comparator → flexible custom ordering
       ✅ Multi-field sorting → salary/budget + department/name
       ✅ Collections.reverse(list) → reverse existing order
       ✅ Modern Java 8+ allows cleaner syntax with lambdas and Comparator chaining

       ✅ Using streams with reduce() works for any type that implements Comparable (Integer, Double, Float, String, Date, custom objects).
        ✅ You can find max: reduce(identity, (a, b) -> a.compareTo(b) > 0 ? a : b)
        ✅ You can find min: reduce(identity, (a, b) -> a.compareTo(b) < 0 ? a : b)
        ✅ Advantage: avoids Collections.max()/min() and shows functional programming knowledge.
        ✅ Can be combined with filters, maps, or custom comparators for complex objects (e.g., Employee.salary, Department.budget).
        ✅ Optional: Always handle empty lists properly when using Optional from stream operations.
*/

public class SortArrayListExample {
    public static void main(String[] args) {
        // 1 simple
        System.out.println("Program 1");
        ArrayList<String> list = new ArrayList<>();

        list.add("Banana");
        list.add("Apple");
        list.add("Mango");
        list.add("Orange");

        System.out.println("Before sorting: " + list);

        // Sort alphabetically.  // uses Comparable internally
        Collections.sort(list);


        System.out.println("After sorting: " + list);

        // Then reverse
        Collections.reverse(list);
        System.out.println("After reverse sorting: " + list);

        // 2 case CASE_INSENSITIVE_ORDER sort.
        System.out.println("Program 2");
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("Banana");
        list2.add("Apple");
        list2.add("Mango");
        list2.add("Orange");

        System.out.println("Before sorting: " + list2);

        list2.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println("After sorting: " + list2);

        // Then reverse
        Collections.reverse(list2);
        System.out.println("After reverse sorting: " + list2);

        // 3. sort using compare to. java 11 style.
        System.out.println("Program 3");
        ArrayList<String> list3 = new ArrayList<>();

        list3.add("Banana");
        list3.add("Apple");
        list3.add("Mango");
        list3.add("Orange");

        System.out.println("Before sorting: " + list3);

        list3.sort(String::compareTo);

        System.out.println("After sorting: " + list3);

        list3.sort(Comparator.reverseOrder());

        System.out.println("After reverse sorting: " + list3);

        // or
        list3.sort(String::compareTo);
        Collections.reverse(list3);

        //Notes: String::compareTo → ascending      Comparator.reverseOrder() → descending


        // 4. sort using lambda expression.        list.sort((a, b) -> a.compareTo(b)); (String using Comparator)
        //  list.sort((a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println("Program 4");
        ArrayList<String> list4 = new ArrayList<>();

        list4.add("Banana");
        list4.add("Apple");
        list4.add("Mango");
        list4.add("Orange");

        System.out.println("Before sorting: " + list4);

        list4.sort((a, b) -> a.compareTo(b));

        System.out.println("After sorting: " + list4);

        // Reverse sorting using lambda
        list4.sort((a, b) -> b.compareTo(a));

        System.out.println("After reverse sorting: " + list4);

        // 5. Custom Sorting list.sort(Comparator.comparing(String::length)); Sort by string length Time complexity → O(n log n)

        System.out.println("Program 5");
        ArrayList<String> list5 = new ArrayList<>();

        list5.add("Banana");
        list5.add("Apple");
        list5.add("Mango");
        list5.add("Orange");

        System.out.println("Before sorting: " + list5);

        list5.sort(Comparator.comparing(String::length));

        System.out.println("After sorting: " + list5);

        // 6. Date Sorting
        System.out.println("Program 6 - Date Sorting");
        try {
            // Date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Create ArrayList of Dates
            ArrayList<Date> dates = new ArrayList<>();

            dates.add(sdf.parse("2026-03-20"));
            dates.add(sdf.parse("2024-12-25"));
            dates.add(sdf.parse("2025-07-15"));
            dates.add(sdf.parse("2023-10-05"));

            System.out.println("Before sorting: " + dates);

            // Sort using Comparable (Date implements Comparable)
            Collections.sort(dates);
            System.out.println("After sorting (ascending): " + dates);

            // Reverse the list
            Collections.reverse(dates);
            System.out.println("After reverse sorting (descending): " + dates);

            // --- Using Comparator explicitly (another way) ---
            dates.sort((d1, d2) -> d1.compareTo(d2)); // ascending
            System.out.println("Ascending with Comparator: " + dates);

            dates.sort((d1, d2) -> d2.compareTo(d1)); // descending
            System.out.println("Descending with Comparator: " + dates);
        } catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }

        // 7. program - custom object sort.
        System.out.println("Program 7 - Employee Sorting");

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 75000));
        employees.add(new Employee("Bob", 50000));
        employees.add(new Employee("Charlie", 75000));
        employees.add(new Employee("David", 60000));

        System.out.println("Before sorting: " + employees);

        // --- Using Comparator: sort by salary ascending ---
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        System.out.println("After sorting by salary ascending: " + employees);

        // --- Sort by salary descending ---
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        System.out.println("After sorting by salary descending: " + employees);

        // --- Sort by salary ascending, then name ascending (tie-breaker) ---
        employees.sort(
                Comparator.comparingDouble((Employee e) -> e.salary)
                        .thenComparing(e -> e.name)
        );
        System.out.println("After sorting by salary, then name ascending: " + employees);


        // 8. Program [custom objects comparable]
        System.out.println("Program 10 - Department Sorting (Comparable & Comparator)");

        ArrayList<Department> departments = new ArrayList<>();

        departments.add(new Department("HR", 75000));
        departments.add(new Department("Finance", 50000));
        departments.add(new Department("IT", 75000));
        departments.add(new Department("Marketing", 60000));

        System.out.println("Before sorting: " + departments);

        // --- 1. Using Comparable (budget ascending) ---
        Collections.sort(departments);
        System.out.println("After Comparable sorting (budget ascending): " + departments);

        // --- 2. Using Comparator: budget descending ---
        departments.sort((d1, d2) -> Double.compare(d2.budget, d1.budget));
        System.out.println("After Comparator sorting (budget descending): " + departments);

        // --- 3. Comparator: budget ascending, then name ascending ---
        departments.sort(
                Comparator.comparingDouble((Department d) -> d.budget)
                        .thenComparing(d -> d.name)
        );
        System.out.println("After Comparator sorting (budget ascending, then name ascending): " + departments);

        // --- 4. Comparator: budget descending, then name descending ---
        departments.sort(
                Comparator.comparingDouble((Department d) -> d.budget).reversed()
                        .thenComparing(Comparator.comparing((Department d) -> d.name).reversed())
        );
        System.out.println("After Comparator sorting (budget descending, then name descending): " + departments);

    }

}
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "($" + salary + ")";
    }
}

class Department implements Comparable<Department> {
    String name;
    double budget; // we can use budget as the main sorting field

    Department(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return name + "($" + budget + ")";
    }

    // Comparable: natural order by budget ascending
    @Override
    public int compareTo(Department other) {
        return Double.compare(this.budget, other.budget);
    }
}