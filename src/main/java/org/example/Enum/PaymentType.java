package org.example.Enum;


import java.util.Random;

public enum PaymentType {
    CARD, CASH;

    public static PaymentType getRandomPaymentType() {
        return values()[new Random().nextInt(values().length)];
    }

    @Override
    public String toString() {
        // Преобразуем имя enum в строку с первой заглавной буквой и остальными строчными
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
