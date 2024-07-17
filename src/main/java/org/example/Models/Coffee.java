package org.example.Models;

public class Coffee {

    private final int id;

    private final String paymentType;

    private final int price;

    private final String typeOfCoffee;

    private Coffee(CoffeeBuilder builder) {
        this.id = builder.id;
        this.paymentType = builder.paymentType;
        this.price = builder.price;
        this.typeOfCoffee = builder.typeOfCoffee;
    }

    public static CoffeeBuilder builder() {
        return new CoffeeBuilder();
    }

    public int getPrice() {
        if (price > 0) {
            return price;
        }
        return 1;
    }

    public static class CoffeeBuilder {

        private int id;

        private String paymentType;

        private int price;

        private String typeOfCoffee;

        public CoffeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CoffeeBuilder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public CoffeeBuilder price(int price) {
            this.price = price;
            return this;
        }

        public CoffeeBuilder typeOfCoffee(String typeOfCoffee) {
            this.typeOfCoffee = typeOfCoffee;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", paymentType='" + paymentType + '\'' +
                ", price=" + price +
                ", typeOfCoffee='" + typeOfCoffee + '\'' +
                '}';
    }
}
