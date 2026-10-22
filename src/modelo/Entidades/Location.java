package modelo.Entidades;

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
    public String toString() {
        return "SEDE: "
                + name +
                "\nCodigo: " + id;
    }
}
