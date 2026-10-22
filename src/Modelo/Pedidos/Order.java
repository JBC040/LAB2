package Modelo.Pedidos;

import Promociones.Promocion;
import Modelo.Entidades.Customer;
import Modelo.Entidades.Location;
import Observadores.ObservadorPedido;
import Modelo.Entidades.Roundsman;
import Modelo.Productos.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final Customer customer;
    private final Location location;
    private final LocalDateTime fecha;
    private final List<OrderDetail> details;
    private final List<ObservadorPedido> observadores;

    private Roundsman roundsman;
    private OrderStatus status;

    public Order(String id, Customer customer, Location location) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Código obligatorio");
        }
        if (customer == null || location == null) {
            throw new IllegalArgumentException(
                    "Cliente y sede son obligatorios"
            );
        }

        this.id = id;
        this.customer = customer;
        this.location = location;
        this.fecha = LocalDateTime.now();
        this.details = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.status = OrderStatus.RECIBIDO;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<OrderDetail> getDetails() {
        return List.copyOf(details);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Roundsman getRoundsman() {
        return roundsman;
    }

    public void asignarRepartidor(Roundsman roundsman) {
        if (roundsman == null) {
            throw new IllegalArgumentException(
                    "El repartidor es obligatorio"
            );
        }
        this.roundsman = roundsman;
    }

    public void agregarProducto(Product product, int cantidad) {
        if (status != OrderStatus.RECIBIDO) {
            throw new IllegalStateException(
                    "Solo se modifica un pedido recién recibido"
            );
        }

        details.add(new OrderDetail(product, cantidad));
    }

    public double calculateSubtotal() {
        return details.stream()
                .mapToDouble(OrderDetail::calculateSubtotal)
                .sum();
    }

    public double calcularTotal(Promocion promocion) {
        double subtotal = calculateSubtotal();

        if (promocion == null) {
            return subtotal;
        }

        return promocion.apply(subtotal);
    }

    public void agregarObservador(ObservadorPedido observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void quitarObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    public void cambiarEstado(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Estado obligatorio");
        }

        if (status == OrderStatus.ENTREGADO
                || status == OrderStatus.CANCELADO) {
            throw new IllegalStateException(
                    "El pedido ya terminó"
            );
        }

        OrderStatus previousStatus = status;
        status = newStatus;

        for (ObservadorPedido observador :
                List.copyOf(observadores)) {
            observador.update(this, previousStatus, newStatus);
        }

        if (newStatus == OrderStatus.ENTREGADO
                && roundsman != null) {
            roundsman.registrarEntrega();
        }
    }

    @Override
    public String toString() {
        return "Pedido: " + id
                + "\nCliente: " + customer.getName()
                + "\nEstado: " + status
                + "\nTotal: " + calculateSubtotal();
    }
}
