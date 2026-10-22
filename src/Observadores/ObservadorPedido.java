package Observadores;

import Modelo.Pedidos.OrderStatus;
import Modelo.Pedidos.Order;

public interface ObservadorPedido {
    void update(Order order, OrderStatus previousStatus, OrderStatus newStatus);
}
