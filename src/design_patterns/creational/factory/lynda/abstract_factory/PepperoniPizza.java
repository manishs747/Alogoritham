package design_patterns.creational.factory.lynda.abstract_factory;

public class PepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
       this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
