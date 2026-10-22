package Observadores;

import Modelo.Pedidos.Order;
import Modelo.Pedidos.OrderStatus;

public class ObservadorCocina implements ObservadorPedido {

    @Override
    public void update(Order order, OrderStatus anterior, OrderStatus nuevo) {

        System.out.println(
                "[COCINA] Pedido " + order.getId()
                        + ": " + anterior + " -> " + nuevo
        );
    }
}

