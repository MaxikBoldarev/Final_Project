package org.example.Enum;

import java.util.Random;

public enum TypeOfCoffee {
    AMERICANO, LATTE, MOCHA, CAPPUCCINO, RISTRETTO, MACCHIATO, LUNGO,
    FLAT_WHITE, CORRETTO, ICED_COFFEE, AFFOGATO, IRISH_COFFEE,
    TURKISH_COFFEE, FRAPPE, ESPRESSO;

    public static TypeOfCoffee getRandomTypeOfCoffee() {
        return values()[new Random().nextInt(values().length)];
    }

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1).replace('_', ' ');
    }
}
