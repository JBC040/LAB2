package Modelo.Pedidos;
import Modelo.Productos.Product;

public class OrderDetail {
    private final Product product;
    private final int ammount;
    private final double prize;

    public OrderDetail(Product product, int ammount) {
        if (product == null) {
            throw new IllegalArgumentException(
                    "El producto es obligatorio"
            );
        }

        if (ammount <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser positiva"
            );
        }


        this.product = product;
        this.ammount = ammount;
        this.prize = product.getInitialPrize();
    }

    public Product getProducto() {
        return product;
    }

    public int getAmmount() {
        return ammount;
    }

    public double getPrize() {
        return prize;
    }

    public double calculateSubtotal() {
        return prize * ammount;
    }

    @Override
    public String toString() {
        return "Detalle de la orden: " +
                "\nProducto: " + product +
                "\nCantidad: " + ammount +
                "\nPrecio: " + prize;
    }
}
