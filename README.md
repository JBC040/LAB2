# LAB2
# Sistema de Gestión de Pedidos - SaborExpress

## Descripción

Este proyecto busca desarrollar un sistema para gestionar los pedidos de SaborExpress, una cadena de restaurantes. Permite organizar la información de los clientes, productos, repartidores, sedes y pedidos.

La idea es aplicar los temas vistos en clase para que el programa sea más organizado y fácil de modificar.

## Participante

- Juan Esteban Betancourt

## Decisiones de diseño

Separamos el programa en varias clases para que cada una tenga una función específica. Por ejemplo, los clientes y productos tienen sus propias clases, mientras que el repositorio se encarga de guardar y buscar la información.

También usamos una clase abstracta para los productos, ya que el menú puede tener platos, bebidas y combos.

## Temas aplicados

- **Colecciones:** usamos `HashMap` para guardar información y buscar elementos por su identificador.
- **Ordenamiento:** usamos `Comparator` para ordenar productos y repartidores con diferentes criterios.
- **Genéricos y wildcards:** creamos un repositorio genérico que permite trabajar con diferentes tipos de objetos.
- **Programación funcional:** usamos Streams para filtrar, ordenar y realizar consultas sobre los datos.
- **SOLID:** separamos las responsabilidades entre las clases para que el código sea más fácil de mantener.
- **Strategy (bonus):** usamos una interfaz para poder agregar diferentes tipos de promociones.
- **Observer (bonus):** permite avisar a los interesados cuando cambia el estado de un pedido.

## Consultas

El sistema busca permitir consultas como los tres platos más vendidos, los ingresos por sede, el pedido más costoso de cada cliente y el desempeño de los repartidores.

## pd: 
Cabe aclarar que para la realización del trabajo, debido a la carga y al volumen de tareas correspondientes al estar trabajando individualmente, me apoye en la IA para la arquitectura del proyecto y detalles muy puntuales
