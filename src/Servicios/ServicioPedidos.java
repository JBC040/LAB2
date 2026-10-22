package Servicios;

import modelo.Entidades.Customer;
import modelo.Pedidos.Order;
import Repositorio.Repositorio;

import java.util.Optional;

public class ServicioPedidos {
    private final Repositorio<Customer> customers;
    private final Repositorio<Order> orders;

    public ServicioPedidos(Repositorio<Customer> customers, Repositorio<Order> orders) {
        this.customers = customers;
        this.orders = orders;
    }

    public boolean registrarCliente(Customer customer) {
        return customers.agregar(customer);
    }

    public Optional<Customer> buscarCliente(String id) {
        return customers.buscar(id);
    }

    public boolean registrarPedido(Order order) {
        return orders.agregar(order);
    }

    public Optional<Order> buscarPedido(String id) {
        return orders.buscar(id);
    }
}
