package Interview.atlas.closestorg;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Requirement Gathering & Assumptions
 * Group hierarchy
 * Each group can contain both employees and sub-groups.
 * Each employee belongs to at least one group.
 *
 * Constraints
 * An employee can belong to multiple groups
 * There can be multiple isolated trees (forest structure)
 * Group names and employee IDs are unique.
 * Problem
 * Given a list of employees, find their closest common parent group in the hierarchy
 *
 *
 *Solution Approach
 *
 * DFS Traversal
 *
 * Start from each group root.
 *
 * For each node, recursively check whether it contains the target employees.
 *
 * The lowest group that contains all target employees is the answer.
 *
 * Memoization
 *
 * Cache results for groups already processed to avoid recomputation.
 *
 * Alternative: BFS or LCA
 *
 * If the hierarchy is strictly a tree with unique employee assignment, we can use Lowest Common Ancestor (LCA).
 *
 * But since employees may exist in multiple groups, DFS with memoization is more flexible.
 *
 * 🔹 Complexity
 *
 * Time Complexity: O(n * (m + k))
 *
 * n = number of groups
 *
 * m = employees per group
 *
 * k = target employees
 *
 * Space Complexity: O(n * m) (cache + recursion stack)Solution Approach
 *
 * DFS Traversal
 *
 * Start from each group root.
 *
 * For each node, recursively check whether it contains the target employees.
 *
 * The lowest group that contains all target employees is the answer.
 *
 * Memoization
 *
 * Cache results for groups already processed to avoid recomputation.
 *
 * Alternative: BFS or LCA
 * If the hierarchy is strictly a tree with unique employee assignment, we can use Lowest Common Ancestor (LCA).
 * But since employees may exist in multiple groups, DFS with memoization is more flexible.
 *
 * 🔹 Complexity
 * Time Complexity: O(n * (m + k)
 * n = number of group
 * m = employees per group
 * k = target employees
 * Space Complexity: O(n * m) (cache + recursion stack)
 *
 */
public class LCADFS {
    // employee can belong to multiple groups

   static class Employee {
        String id;
        String name;
        Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

   static class Group {
        String name;
        List<Employee> employees = new ArrayList<>();
        List<Group> subGroups = new ArrayList<>();
        Group(String name) {
            this.name = name;
        }

        void addEmployee(Employee e) {
            employees.add(e);
        }

        void addSubGroup(Group g) {
            subGroups.add(g);
        }
    }


    // Helper result wrapper
    private static class Result {
        Set<String> foundEmployees;
        Group closestGroup;
        Result(Set<String> foundEmployees, Group closestGroup) {
            this.foundEmployees = foundEmployees;
            this.closestGroup = closestGroup;
        }
    }



    public  Group findClosestCommonGroup(Group root, Set<String> targetEmployees) {
        if (root == null || targetEmployees.isEmpty()) return null;
        return dfs(root, targetEmployees).closestGroup;
    }


    private Result dfs(Group group, Set<String> targetEmployees) {
        Set<String>  foundEmployee = new HashSet<>();
        for(Employee emp : group.employees){
          if(targetEmployees.contains(emp.id))
              foundEmployee.add(emp.id);
        }

        Group candidateGroup = null;
        for ( Group subGroup : group.subGroups){
            Result subResult = dfs(subGroup,targetEmployees);
            foundEmployee.addAll(subResult.foundEmployees);
            if (subResult.closestGroup != null) {
                candidateGroup = subResult.closestGroup;
            }
        }

        if(foundEmployee.containsAll(targetEmployees) && candidateGroup == null){
            return  new Result(foundEmployee,group);
        }
        return new Result(foundEmployee,candidateGroup);
    }

    public static void main(String[] args) {
        // Employees
        Employee e1 = new Employee("E1", "Alice");
        Employee e2 = new Employee("E2", "Bob");
        Employee e3 = new Employee("E3", "Charlie");
        Employee e4 = new Employee("E4", "David");

        // Groups
        Group root = new Group("Root");
        Group g1 = new Group("Engineering");
        Group g2 = new Group("HR");
        Group g11 = new Group("Backend");
        Group g12 = new Group("Frontend");

        // Build hierarchy
        root.addSubGroup(g1);
        root.addSubGroup(g2);
        g1.addSubGroup(g11);
        g1.addSubGroup(g12);

        g11.addEmployee(e1);
        g11.addEmployee(e2);
        g12.addEmployee(e3);
        g2.addEmployee(e4);

        LCADFS solver = new LCADFS();

        // Case 1: Single group with all employees
        System.out.println("Case 1: [E1,E2] -> " +
                solver.findClosestCommonGroup(root, Set.of("E1","E2")).name);

        // Case 2: Multiple groups with common parent
        System.out.println("Case 2: [E1,E3] -> " +
                solver.findClosestCommonGroup(root, Set.of("E1","E3")).name);

        // Case 3: Employees across distant groups
        System.out.println("Case 3: [E1,E4] -> " +
                solver.findClosestCommonGroup(root, Set.of("E1","E4")).name);

        // Case 4: Empty employees
        System.out.println("Case 4: [] -> " +
                solver.findClosestCommonGroup(root, Set.of()));

        // Case 5: Non-existent employee
        System.out.println("Case 5: [E9] -> " +
                solver.findClosestCommonGroup(root, Set.of("E9")));

    }


}
