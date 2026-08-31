package Interview.atlas.closestorg.latest;

import java.util.HashSet;
import java.util.Set;

    public class LCADFSNEW {
        private Group lca = null;

        public Group findClosestCommonGroup(Group root, Set<String> targetEmployees) {
            if (root == null || targetEmployees == null || targetEmployees.isEmpty()) return root;
             dfs(root,targetEmployees);
             return lca;
        }

        public Set<String> dfs(Group group, Set<String> targetEmployees){
            if(group == null || lca != null) return new HashSet<>();
            Set<String> availableEmployees = new HashSet<>();
            for (Employee emp: group.employees){
                if(targetEmployees.contains(emp.id)){
                    availableEmployees.add(emp.id);
                }
            }
            for (Group subgroup : group.subGroups){
                if(lca != null) return availableEmployees;
                availableEmployees.addAll(dfs(subgroup, targetEmployees));
            }
            if(lca == null  &&  availableEmployees.containsAll(targetEmployees))    {
                lca = group;
            }
            return availableEmployees;
        }

    public static void main(String[] args) {
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

        root.addSubGroup(g1);
        root.addSubGroup(g2);
        g1.addSubGroup(g11);
        g1.addSubGroup(g12);

        g11.addEmployee(e1);
        g11.addEmployee(e2);
        g12.addEmployee(e3);
        g2.addEmployee(e4);


        LCADFSNEW solver1 = new LCADFSNEW();
        System.out.println("Set-based [E1,E2] -> " +
                solver1.findClosestCommonGroup(root, Set.of("E1","E4")));

    }
}
