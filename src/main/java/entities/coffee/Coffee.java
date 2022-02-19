package entities.coffee;

public abstract class Coffee {
    double price;
    String sort;

    public Coffee(double price, String sort) {
        this.price = price;
        this.sort = sort;
    }
}
