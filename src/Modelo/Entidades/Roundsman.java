package Modelo.Entidades;

import java.util.Objects;

public class Roundsman {
    private final String id;
    private String name;
    private double calification;
    private int deliveries;

    public Roundsman(String identificacion, String name) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException(
                    "Identificación obligatoria"
            );
        }

        this.id = identificacion;
        this.name = name;
        this.calification = 0;
        this.deliveries = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCalification() {
        return calification;
    }

    public int getDeliveries() {
        return deliveries;
    }

    public void registrarCalificacion(double calificacion) {
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException(
                    "La calificación debe estar entre 1 y 5"
            );
        }

        this.calification =
                (this.calification * deliveries + calificacion) / (deliveries + 1);
    }

    public void registrarEntrega() {
        deliveries++;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Roundsman roundsman)) return false;
        return Objects.equals(id, roundsman.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Repartidor: " + name +
                "\nCalificación: " + calification
                +"\nEntregas: " + deliveries;
    }
}
