package advaith;

public class NestedName {

    public static void main(String[] args) {
        String name = "Advaith ";
        for (int i = 0; i < 1000; i++) {
            System.out.println(name);
            name = name + "Advaith ";
        }
    }
}
