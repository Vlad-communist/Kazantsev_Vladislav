package org.example;


public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.brand = "Lada";
        car.year = 2023;
        car.color = "Красный";

        System.out.println("Бренд: " + car.brand);
        System.out.println("Год выпуска: " + car.year);
        System.out.println("Цвет: " + car.color);
    }
}
