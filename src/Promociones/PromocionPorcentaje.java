package Promociones;

public class PromocionPorcentaje implements Promocion {
    private final double percentage;

    public PromocionPorcentaje(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100"
            );
        }

        this.percentage = percentage;
    }

    @Override
    public double apply(double subtotal) {
        return subtotal * (1 - percentage / 100.0);
    }
}
