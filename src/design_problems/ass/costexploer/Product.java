package design_problems.ass.costexploer;

import java.util.Objects;

public class Product {
    private final String name;

    public Product(String name, Plan plan) {
        this.name = Objects.requireNonNull(name, "Product name cannot be null");
    }
    public String getName() { return name; }
}
