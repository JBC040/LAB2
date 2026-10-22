package Repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Repositorio<T> {
    private final Map<String, T> datos = new HashMap<>();
    private final Function<? super T, String> obtenerId;

    public Repositorio(Function<? super T, String> obtenerId) {
        this.obtenerId = obtenerId;
    }

    public boolean agregar(T elemento) {
        String id = obtenerId.apply(elemento);

        if (datos.containsKey(id)) {
            return false;
        }

        datos.put(id, elemento);
        return true;
    }

    public void agregarTodos(Iterable<? extends T> elementos) {
        for (T elemento : elementos) {
            agregar(elemento);
        }
    }

    public Optional<T> buscar(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public Collection<T> obtenerTodos() {
        return java.util.List.copyOf(datos.values());
    }

    public boolean eliminar(String id) {
        return datos.remove(id) != null;
    }

    public int cantidad() {
        return datos.size();
    }
}
