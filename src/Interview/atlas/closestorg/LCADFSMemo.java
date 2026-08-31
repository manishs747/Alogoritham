package Interview.atlas.closestorg;


import java.util.*;

public class LCADFSMemo {

    private Map<Group, Set<String>> memo = new HashMap<>();

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

    private Set<String> getEmployeesInGroup(Group group) {
        // If cached, return immediately
        if (memo.containsKey(group)) {
            return memo.get(group);
        }
        Set<String> result = new HashSet<>();
        for (Employee e : group.employees) {
            result.add(e.id);
        }
        for (Group sub : group.subGroups) {
            result.addAll(getEmployeesInGroup(sub));
        }
        // Memoize before returning
        memo.put(group, result);
        return result;
    }



    public  Group findClosestCommonGroup(Group root, Set<String> targetEmployees) {
        if (root == null || targetEmployees.isEmpty()) return null;
        return dfs(root, targetEmployees);
    }


    private Group dfs(Group group, Set<String> targetEmployees) {
        Set<String> coverage = getEmployeesInGroup(group);

        // If no target employees here → prune
        if (Collections.disjoint(coverage, targetEmployees)) {
            return null;
        }

        Group candidate = null;

        // Check subgroups recursively
        for (Group sub : group.subGroups) {
            Group subResult = dfs(sub, targetEmployees);
            if (subResult != null) {
                candidate = subResult; // propagate closest candidate found below
            }
        }

        // If this group covers all targets and no closer subgroup exists
        if (coverage.containsAll(targetEmployees)) {
            return candidate != null ? candidate : group;
        }

        return candidate;
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

        LCADFSMemo solver = new LCADFSMemo();

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
