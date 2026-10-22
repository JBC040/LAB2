package Observadores;

import modelo.Pedidos.OrderStatus;
import modelo.Pedidos.Order;

public interface ObservadorPedido {
    void update(Order order, OrderStatus previousStatus, OrderStatus newStatus);
}
