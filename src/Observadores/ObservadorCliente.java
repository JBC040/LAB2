package Observadores;

import modelo.Pedidos.OrderStatus;
import modelo.Pedidos.Order;

public class ObservadorCliente implements ObservadorPedido {

    @Override
    public void update(Order order, OrderStatus previousStatus, OrderStatus newStatus) {

        System.out.println(
                "[CLIENTE] Hola, " + order.getCustomer().getName()
                        + ". Tu pedido " + order.getId()
                        + " ahora está: " + newStatus
        );
    }
}
