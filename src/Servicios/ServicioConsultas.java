package Servicios;

import Modelo.Entidades.Customer;
import Modelo.Entidades.Location;
import Modelo.Entidades.Roundsman;
import Modelo.Pedidos.Order;
import Modelo.Pedidos.OrderDetail;
import Modelo.Pedidos.OrderStatus;
import Modelo.Productos.Dish;
import Modelo.Productos.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServicioConsultas {

    public List<Order> filtrarPedidos(Collection<Order> orders, Predicate <Order> criterio) {

        return orders.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public List<Product> ordenarProductos(
            Collection<? extends Product> products) {

        return products.stream()
                .sorted(
                        Comparator.comparingDouble(Product::getInitialPrize)
                                .reversed()
                                .thenComparing(Product::getName)
                )
                .collect(Collectors.toList());
    }


    public List<Roundsman> ordenarRepartidores(
            Collection<Roundsman> repartidores) {

        return repartidores.stream()
                .sorted(
                        Comparator.comparingDouble(
                                        Roundsman::getCalification
                                ).reversed()
                                .thenComparing(
                                        Comparator.comparingInt(
                                                Roundsman::getDeliveries
                                        ).reversed()
                                )
                )
                .collect(Collectors.toList());
    }

    public List<Map.Entry<Dish, Integer>> top3PlatosVendidos(Collection<Order> orders, LocalDate desde, LocalDate hasta) {

        Map<Dish, Integer> ventas = orders.stream()
                .filter(p -> {
                    LocalDate fecha = p.getFecha().toLocalDate();
                    return !fecha.isBefore(desde)
                            && !fecha.isAfter(hasta);
                })
                .flatMap(p -> p.getDetails().stream())
                .filter(d -> d.getProducto() instanceof Dish)
                .collect(Collectors.groupingBy(
                        d -> (Dish) d.getProducto(),
                        Collectors.summingInt(OrderDetail::getAmmount)
                ));

        return ventas.entrySet().stream()
                .sorted(
                        Map.Entry.<Dish, Integer>comparingByValue()
                                .reversed()
                )
                .limit(3)
                .collect(Collectors.toList());
    }

    public Map<Location, Double> ingresosPorSede(Collection<Order> orders) {

        return orders.stream()
                .filter(p -> p.getStatus() != OrderStatus.CANCELADO)
                .collect(Collectors.groupingBy(
                        Order::getLocation,
                        Collectors.summingDouble(Order::calculateSubtotal)
                ));
    }

    public Map<Customer, Optional<Order>> pedidoMasCaroPorCliente(
            Collection<Order> orders) {

        return orders.stream()
                .filter(p -> p.getStatus() != OrderStatus.CANCELADO)
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.maxBy(Comparator.comparingDouble(Order::calculateSubtotal)
                        ))
                );
    }
}
