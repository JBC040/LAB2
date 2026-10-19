package modelo.Productos;

import java.util.Comparator;

public abstract class Product implements Comparable <Product> {
    private String name;
    private double initialPrize;

    public Product(String name, double initialPrize) {
        this.name = name;
        this.initialPrize = initialPrize;
    }

    public String getName() {
        return name;
    }

    public double getInitialPrize() {
        return initialPrize;
    }

    public abstract double calcPrize();

    @Override
    public int compareTo(Product o) {
        return Double.compare (this.initialPrize, o.initialPrize);
    }

    Comparator <Product> comparatorName = Comparator.comparing(Product::getName);

    @Override
    public String toString() {
        return "Nombre: " + name +
                "\n Precio sin descuentos aplicados: " + initialPrize;
    }
}
