package Modelo.Productos;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getInitialPrize() {
        return initialPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nombre: " + name +
                "\n Precio sin descuentos aplicados: " + initialPrize;
    }
}
