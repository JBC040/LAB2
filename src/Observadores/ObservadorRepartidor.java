package Observadores;

import Modelo.Pedidos.OrderStatus;
import Modelo.Pedidos.Order;

public class ObservadorRepartidor implements ObservadorPedido {

    @Override
    public void update(Order order, OrderStatus anterior, OrderStatus nuevo) {

        if (nuevo == OrderStatus.LISTO || nuevo == OrderStatus.EN_CAMINO) {
            System.out.println("[REPARTIDOR] Actualización del pedido " + order.getId() + ": " + nuevo);
        }
    }
}