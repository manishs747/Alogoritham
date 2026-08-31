package Interview.atlas.closestorg.latest.practice;





import Interview.atlas.closestorg.latest.Group;

import java.util.*;

public class ClosestCommonGroup {

    private static class Employee {
        String id;
        String name;
        Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        Employee(String  id){
            this.id = id;
        }
    }

    private static class Group {

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

        @Override
        public String toString() {
            return this.name;
        }
    }

    private Group lca = null;
    private final Set<Group> candidates = new HashSet<>();
    private  final Map<Group,Set<String>>  memo = new HashMap<>();

    public Group findClosestCommonGroup(Group root, Set<String> targetEmployees) {
      if(root == null || targetEmployees == null || targetEmployees.isEmpty()) return root;
      dfs(root ,targetEmployees);
      return lca;
    }


    private Set<String> dfs(Group root, Set<String> targetEmployees) {
        if(root == null || lca != null) return new HashSet<>();
        Set<String>  availbleEmpSet = new HashSet<>();
        for (Employee emp: root.employees){
            if(targetEmployees.contains(emp.id)){
                availbleEmpSet.add(emp.id);
            }
        }

        for (Group subgrp :root.subGroups){
              if(lca != null) return availbleEmpSet;
              availbleEmpSet.addAll(dfs(subgrp,targetEmployees));
        }

       if(lca == null && availbleEmpSet.containsAll(targetEmployees)){
           lca = root;
       }
       return availbleEmpSet;
    }

    public Group findClosestCommonGroupDAG(Group root, Set<String> targetEmployees) {
        if(root == null || targetEmployees == null || targetEmployees.isEmpty()) return  null;
         dfsDAG(root,targetEmployees);
         if(candidates.isEmpty()) return null;

         return candidates.iterator().next();

    }

    private Set<String> dfsDAG(Group root, Set<String> targetEmployees) {
        if(root == null) return new HashSet<>();
        if(memo.containsKey(root)) return memo.get(root);
        Set<String> availableEmp = new HashSet<>();
        for (Employee emp:root.employees){
            if(targetEmployees.contains(emp)){
                availableEmp.add(emp.id);
            }
        }

        for (Group subGroup :root.subGroups){
            availableEmp.addAll(dfs(subGroup,targetEmployees));
        }

        if(availableEmp.containsAll(targetEmployees)){
            candidates.add(root);
        }

        memo.put(root,availableEmp);


        return availableEmp;
    }


    //***************DAG****************

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


        ClosestCommonGroup solver1 = new ClosestCommonGroup();
        System.out.println("Set-based [E1,E2] -> " +
                solver1.findClosestCommonGroup(root, Set.of("E1","E3")));
    }
}
