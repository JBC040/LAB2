package modelo.Productos;

public abstract class Product {
    private String id;
    private String name;
    private double initialPrize;

    public Product(String id, String name, double initialPrize) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Código obligatorio");
        }
        if (initialPrize <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }


        this.id = id;
        this.name = name;
        this.initialPrize = initialPrize;
    }

    public String getName() {
        return name;
    }

    public double getInitialPrize() {
        return initialPrize;
    }

    @Override
    public String toString() {
        return "Nombre: " + name +
                "\n Precio sin descuentos aplicados: " + initialPrize;
    }
}
