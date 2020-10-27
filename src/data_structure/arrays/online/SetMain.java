package data_structure.arrays.online;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

    //delete: 1
    //add 3




    public static void main(String[] args) {
        Set<String> update = new HashSet<>();  //c,d
        update.add("2");
        update.add("3");

        Set<String> existing = new HashSet<>(); //a,b,c
        existing.add("1");
        existing.add("2");





        Set<String> delete = new HashSet<>(existing);
        delete.removeAll(update);
        System.out.println("Delete:"+delete);


        Set<String> add = new HashSet<>(update);
        add.removeAll(existing);
        System.out.println("Add:"+add);




    }
}
