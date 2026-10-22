package Modelo.Entidades;

import java.util.Objects;

public class Location {
    private final String id;
    private String name;

    public Location(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Código obligatorio");
        }

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location location)) return false;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SEDE: "
                + name +
                "\nCodigo: " + id;
    }
}
