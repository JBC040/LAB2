import Repositorio.Repositorio;
import Promociones.Promocion;
import Promociones.PromocionPorcentaje;
import Observadores.*;
import Servicios.ServicioPedidos;
import Servicios.ServicioConsultas;
import Modelo.Entidades.Customer;
import Modelo.Entidades.Location;
import Modelo.Entidades.Roundsman;
import Modelo.Pedidos.Order;
import Modelo.Pedidos.OrderStatus;
import Modelo.Productos.Combo;
import Modelo.Productos.Dish;
import Modelo.Productos.Drink;
import Modelo.Productos.Product;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Repositorio<Customer> customers =
                new Repositorio<> (Customer::getId);

        Repositorio<Product> products =
                new Repositorio<>(Product::getId);

        Repositorio<Order> orders =
                new Repositorio<>(Order::getId);

        Repositorio<Roundsman> repartidores =
                new Repositorio<>(Roundsman::getId);

        ServicioPedidos servicioPedidos =
                new ServicioPedidos(customers, orders);

        ServicioConsultas consultas = new ServicioConsultas();

        Customer customer1 = new Customer("Juan", "1234");

        Customer clienteDuplicado = new Customer("Juanes", "1234");

        Location location1 = new Location("S01", "Sede Centro");

        Dish hamburguesa = new Dish("P01", "Hamburguesa", 25000, "Comida rápida");

        Dish pizza = new Dish("P02", "Pizza", 30000, "Italiana");

        Drink gaseosa = new Drink("B01", "Gaseosa", 5000, 400);

        Combo combo = new Combo("C01", "Combo familiar", 45000, "Hamburguesas, papas y bebidas");

        Roundsman repartidor1 = new Roundsman("R01", "Carlos");

        System.out.println("Cliente registrado: " + servicioPedidos.registrarCliente(customer1));

        System.out.println("Cliente duplicado registrado: " + servicioPedidos.registrarCliente(clienteDuplicado));


        products.agregar(hamburguesa);
        products.agregar(pizza);
        products.agregar(gaseosa);
        products.agregar(combo);

        repartidores.agregar(repartidor1);

        Order order1 = new Order("PED01", customer1, location1);

        order1.agregarProducto(hamburguesa, 2);
        order1.agregarProducto(gaseosa, 2);

        order1.asignarRepartidor(repartidor1);

        order1.agregarObservador(new ObservadorCocina());
        order1.agregarObservador(new ObservadorCliente());
        order1.agregarObservador(new ObservadorRepartidor());

        servicioPedidos.registrarPedido(order1);

        Promocion descuento = new PromocionPorcentaje(10);

        System.out.println("\nSubtotal: $" + order1.calculateSubtotal());

        System.out.println("Total con descuento: $" + order1.calcularTotal(descuento));

        order1.cambiarEstado(OrderStatus.EN_PREPARACION);
        order1.cambiarEstado(OrderStatus.LISTO);
        order1.cambiarEstado(OrderStatus.EN_CAMINO);
        order1.cambiarEstado(OrderStatus.ENTREGADO);

        servicioPedidos.buscarCliente("12345")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Cliente no encontrado")
                );

        System.out.println("\nProductos ordenados:");

        consultas.ordenarProductos(products.obtenerTodos())
                .forEach(System.out::println);


        System.out.println("\nRepartidores ordenados:");

        consultas.ordenarRepartidores(repartidores.obtenerTodos())
                .forEach(System.out::println);


        System.out.println("\nTop 3 platos vendidos:");

        consultas.top3PlatosVendidos(
                orders.obtenerTodos(),
                LocalDate.now().minusDays(6),
                LocalDate.now()
        ).forEach(entrada ->
                System.out.println(
                        entrada.getKey().getName()
                                + " | Unidades vendidas: "
                                + entrada.getValue()
                )
        );

        System.out.println("\nIngresos por sede:");

        consultas.ingresosPorSede(orders.obtenerTodos())
                .forEach((sede, ingreso) ->
                        System.out.println(
                                sede.getName() + ": $" + ingreso
                        )
                );


        System.out.println("\nPedido más caro por cliente:");

        consultas.pedidoMasCaroPorCliente(orders.obtenerTodos())
                .forEach((cliente, pedido) ->
                        pedido.ifPresent(p ->
                                System.out.println(
                                        cliente.getName()
                                                + " -> " + p.getId()
                                                + " ($" + p.calculateSubtotal() + ")"
                                )
                        )
                );
    }
}
