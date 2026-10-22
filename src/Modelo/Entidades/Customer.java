package Modelo.Entidades;
import java.util.Objects;

public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\n Nombre: " + name +
                "\n Documento: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer)) return false;
        Customer cliente = (Customer) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}