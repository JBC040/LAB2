package modelo.Productos;

public class Drink extends Product {
    private int mililitros;

    public Drink(String id, String name, double initialPrize, int mililitros) {
        if (mililitros <= 0) {
            throw new IllegalArgumentException(
                    "Los mililitros deben ser positivos"
            );
        }

        super(id, name, initialPrize);
        this.mililitros = mililitros;
    }

    public int getMililitros() {
        return mililitros;
    }
}
