package Interview.atlas.closestorg;


import java.util.*;

/*

Reasonable Assumptions

For this solution:
The org hierarchy is a tree (simpler case; we can later extend to DAG).

Each employee belongs to exactly one group.
We need to return the lowest (deepest) group containing all given employees

Build a set of ancestors for the first employee (up to root).
For every other employee:
Traverse its parent chain until root.
Intersect with existing ancestor set.
At the end, pick the deepest (lowest) ancestor in the intersection.
 */
public class lCA1 {

    static class Employee {
        String id;
        String name;
        Group group;   // NEW: direct reference to the employee's group

        Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class Group {
        String name;
        List<Employee> employees = new ArrayList<>();
        List<Group> subGroups = new ArrayList<>();
        Group parent;

        Group(String name) {
            this.name = name;
        }

        void addEmployee(Employee e) {
            e.group = this;    // set back-reference
            employees.add(e);
        }

        void addSubGroup(Group g) {
            g.parent = this;   // set parent
            subGroups.add(g);
        }
    }

    public Group findClosestGroup(List<Employee> employees) {
         List<Group> groups = new ArrayList<>();
         for (Employee emp : employees){
             groups.add(emp.group);
         }
        return findClosestGroupHelper(groups);
    }

    public Group findClosestGroupHelper(List<Group> groups) {
        if(groups == null || groups.isEmpty()) return null;
        Group lca = groups.get(0);
        for (int i = 1; i < groups.size(); i++) {
            lca = findLCA(lca,groups.get(i));
        }
        return lca;
    }

    public Group findLCA(Group g1 , Group g2){
       Set<Group> ancestors = new HashSet<>();
       Group cur = g1;
        while (cur != null){
            ancestors.add(cur);
            cur =cur.parent;
        }
        cur = g2;
        while (cur != null){
            if(ancestors.contains(cur)) return cur;
        }
        return  null;
    }


    public static void main(String[] args) {
        Employee e1 = new Employee("E1", "Alice");
        Employee e2 = new Employee("E2", "Bob");
        Employee e3 = new Employee("E3", "Charlie");
        Employee e4 = new Employee("E4", "David");

        Group root = new Group("Root");
        Group g1 = new Group("Engineering");
        Group g2 = new Group("HR");
        Group g11 = new Group("Backend");
        Group g12 = new Group("Frontend");

        root.addSubGroup(g1);
        root.addSubGroup(g2);
        g1.addSubGroup(g11);
        g1.addSubGroup(g12);

        g11.addEmployee(e1);
        g11.addEmployee(e2);
        g12.addEmployee(e3);
        g2.addEmployee(e4);

        lCA1 solver = new lCA1();

        System.out.println("Case 1: [E1, E2] -> " +
                solver.findClosestGroup(Arrays.asList(e1,e2)).name);

       /* System.out.println("Case 2: [E1, E3] -> " +
                solver.findClosestCommonGroup(Set.of(e1, e3)).name);

        System.out.println("Case 3: [E1, E4] -> " +
                solver.findClosestCommonGroup(Set.of(e1, e4)).name);

        System.out.println("Case 4: [E3] -> " +
                solver.findClosestCommonGroup(Set.of(e3)).name);

        System.out.println("Case 5: Empty -> " +
                solver.findClosestCommonGroup(Set.of()));*/
    }



}
