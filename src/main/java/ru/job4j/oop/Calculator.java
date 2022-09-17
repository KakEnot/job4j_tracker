package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divine(int y) {
        return (double) y / x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divine(y);
    }

    public static void main(String[] args) {
        int rsl = Calculator.sum(10);
        System.out.println("sum "+rsl);
        Calculator calculator = new Calculator();
        rsl = calculator.multiply(5);
        System.out.println("multiply "+rsl);
        rsl=Calculator.minus(7);
        System.out.println("minus "+rsl);
        double rslt=calculator.divine(11);
        System.out.println("divine "+rslt);
        rslt=calculator.sumAllOperation(11);
        System.out.println("sumAllOperation "+rslt);
    }
}