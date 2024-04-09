package com.telran.homeworks;

public class Homework_02 {
    public static void main(String[] args) {
        int a = 20;
        int b = 507;
        double c = 13.70;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));

        System.out.println("c * a = " + (c * a));
        System.out.println("c / 0 = " + (c / 0));
        System.out.println("");

        int num = 345;
        System.out.println("Число " + num + " : "
                + (num / 100) + ", "
                + (num /10 - ((num / 100) * 10)) + ", "
                + num % 10);
    }
}
