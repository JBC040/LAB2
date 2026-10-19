package modelo.Productos;

public class Combo extends ProductWithDescription {

    public Combo(String name, double initialPrize, String description) {
        super(name, initialPrize, description);
    }

    @Override
    public double calcPrize() {
        return 0;
    }
}
