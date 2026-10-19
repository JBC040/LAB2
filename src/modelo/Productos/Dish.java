package modelo.Productos;

public class Dish extends ProductWithDescription {

    public Dish(String name, double initialPrize, String description) {
        super(name, initialPrize, description);
    }

    @Override
    public double calcPrize() {
        return 0;
    }
}
