package modelo.Productos;

public class Drink extends Product {
    private String type;
    private String sour;

    public Drink(String name, double initialPrize, String type, String sour) {
        super(name, initialPrize);
        this.type = type;
        this.sour = sour;
    }

    public String getType() {
        return type;
    }

    public String getSour() {
        return sour;
    }

    @Override
    public double calcPrize() {
        return 0;
    }
}
