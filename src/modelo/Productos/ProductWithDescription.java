package modelo.Productos;

public abstract class ProductWithDescription extends Product {
    private String description;

    public ProductWithDescription(String name, double initialPrize, String description) {
        super(name, initialPrize);
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Descripcion: " + description;
    }
}
