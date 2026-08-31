package Interview.atlas.closestorg.latest;

import java.util.*;



public class ClosestCommonGroupDAG {
    private final Set<Group> candidates = new HashSet<>();
    private final Map<Group, Set<String>> memo = new HashMap<>();

    // Main API
    public Group findClosestCommonGroup(Group root, Set<String> targetEmployees) {
        if (root == null || targetEmployees == null || targetEmployees.isEmpty()) {
            return null;
        }

        dfs(root, targetEmployees);

        if (candidates.isEmpty()) return null;

        // Tie-breaking: smallest group (size of employee set), then alphabetical
        return candidates.stream()
                .sorted(Comparator
                        .comparingInt((Group g) -> g.employees.size())
                        .thenComparing(g -> g.name))
                .findFirst()
                .orElse(null);
    }

    // DFS with memoization
    private Set<String> dfs(Group group, Set<String> targetEmployees) {
        if (memo.containsKey(group)) return memo.get(group);// cycle detection
        Set<String> availableEmployees = new HashSet<>();
        for (Employee emp : group.employees) {
            if (targetEmployees.contains(emp.id)) {
                availableEmployees.add(emp.id);
            }
        }
        for (Group sub : group.subGroups) {
            availableEmployees.addAll(dfs(sub, targetEmployees));
        }
        // If this group covers all targets → candidate
        if (availableEmployees.containsAll(targetEmployees)) {
            candidates.add(group);
        }
        memo.put(group, availableEmployees);
        return availableEmployees;
    }

    // ------------------ Demo ------------------
    public static void main(String[] args) {
        // Build employees
        Employee e1 = new Employee("E1");
        Employee e2 = new Employee("E2");
        Employee e3 = new Employee("E3");

        // Build groups
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");
        Group g3 = new Group("G3");
        Group g4 = new Group("G4");

        // Assign employees
        g2.employees.add(e1);
        g3.employees.add(e2);
        g4.employees.add(e1);
        g4.employees.add(e2);
        g4.employees.add(e3);

        // Build hierarchy (DAG: g4 is shared)
        g1.subGroups.add(g2);
        g1.subGroups.add(g3);
        g2.subGroups.add(g4);
        g3.subGroups.add(g4);

        // Target employees
        Set<String> targets = new HashSet<>(Arrays.asList("E1", "E2"));

        ClosestCommonGroupDAG solver = new ClosestCommonGroupDAG();
        Group result = solver.findClosestCommonGroup(g1, targets);
        System.out.println("Closest Common Group: " + (result != null ? result.name : "None"));
    }
}
