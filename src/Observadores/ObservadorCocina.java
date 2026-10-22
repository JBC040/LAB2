package Observadores;

import modelo.Pedidos.Order;
import modelo.Pedidos.OrderStatus;

public class ObservadorCocina implements ObservadorPedido {

    @Override
    public void update(Order order, OrderStatus anterior, OrderStatus nuevo) {

        System.out.println(
                "[COCINA] Pedido " + order.getId()
                        + ": " + anterior + " -> " + nuevo
        );
    }
}

