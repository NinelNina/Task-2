package ru.vsu.cs.kravtsova.nina.task2;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public  static double inputDouble(String paramName){
        Scanner input = new Scanner(System.in);

        System.out.printf("%s = ", paramName);
        double param = input.nextDouble();

        return param;
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        System.out.printf("Введите координаты точки A:%n");

        double x = inputDouble("x1");
        double y = inputDouble("y1");
        Point A = new Point(x, y);

        System.out.printf("Введите координаты точки B:%n");
        x = inputDouble("x2");
        y = inputDouble("y2");
        Point B = new Point(x, y);

        System.out.printf("Введите координаты точки C:%n");
        x = inputDouble("x3");
        y = inputDouble("y3");
        Point C = new Point(x, y);

        Triangle triangle = new Triangle(A, B, C);

        System.out.print(triangle.getTypeOfTriangle());
    }
}
