package Modelo.Productos;

public abstract class ProductWithDescription extends Product {
    private String description;

    public ProductWithDescription(String id, String name, double initialPrize, String description) {
        super(id, name, initialPrize);
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Descripcion: " + description;
    }
}
