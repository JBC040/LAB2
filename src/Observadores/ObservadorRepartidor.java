package Observadores;

import modelo.Pedidos.OrderStatus;
import modelo.Pedidos.Order;

public class ObservadorRepartidor implements ObservadorPedido {

    @Override
    public void update(Order order, OrderStatus anterior, OrderStatus nuevo) {

        if (nuevo == OrderStatus.LISTO || nuevo == OrderStatus.EN_CAMINO) {
            System.out.println("[REPARTIDOR] Actualización del pedido " + order.getId() + ": " + nuevo);
        }
    }
}