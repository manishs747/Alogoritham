package Interview.atlas.closestorg.latest;

import Interview.atlas.closestorg.LCADFS;

import java.util.ArrayList;
import java.util.List;

public class Group {

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
