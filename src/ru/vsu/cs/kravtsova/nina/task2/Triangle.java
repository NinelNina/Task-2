package ru.vsu.cs.kravtsova.nina.task2;

import java.util.*;

public class Triangle {

    private Point point1;
    private Point point2;
    private Point point3;

    private double a;
    private double b;
    private double c;

    //является ли треугольник равносторонним

    boolean isEquilateral;

    //является ли треугольник равнобедренным
    boolean isIsosceles;

    //является ли треугольник остроугольным
    boolean isAcutedAngled;

    //является ли треугольник прямоугольным
    boolean isRectangular;

    //является ли треугольник тупоугольным
    boolean isObtuse;

    Triangle(Point pointA, Point pointB, Point pointC){
        point1 = pointA;
        point2 = pointB;
        point3 = pointC;

        a = Point.calculateDistance(point2, point3);
        b = Point.calculateDistance(point3, point1);
        c = Point.calculateDistance(point1, point2);
    }

    private static boolean equals(double a, double b){
        return Math.abs(a-b) < 1e-10;
    }

    boolean isTriangle(Point point1, Point point2, Point point3){

        if (equals(((point3.getY() - point1.getY()) / (point2.getY() - point1.getY())), ((point3.getX() - point1.getX()) / (point2.getX() - point1.getX())) )) {
            return false;
        }
        else {
            return true;
        }
    }

    void isEqual(){
        if (equals(a, b) && equals(b, c)){
            //треугольник равносторонний
            isEquilateral = true;
        } else if (equals(a, b) || equals(a, c) || equals(b, c)) {
            //треугольник равнобедренный
            isIsosceles = true;
        }
    }

    void findingTypeOfTriangle(){

        ArrayList<Double> edge = new ArrayList<>();

        List<Double> edges = new ArrayList<>(3);
        edges.add(a);
        edges.add(b);
        edges.add(c);
        edges.sort(Comparator.reverseOrder());

        double squareBigEdge = Math.pow(edges.get(0), 2);
        double squareAEdge = Math.pow(edges.get(1), 2);
        double squareBEdge = Math.pow(edges.get(2), 2);

        //if (squareBigEdge == squareAEdge + squareBEdge) {
        if(equals(squareBigEdge, squareAEdge + squareBEdge)){
            //треугольник прямоугольный
            isRectangular = true;
        } else if (squareBigEdge < squareAEdge + squareBEdge) {
            //треугольник остроугольный
            isAcutedAngled = true;
        } else if (squareBigEdge > squareAEdge + squareBEdge) {
            //треугольник тупоугольный
            isObtuse = true;
        }
    }

    public String getTypeOfTriangle(){

        String typeOfTriangle;

        if (isTriangle(point1, point2, point3)) {

            isEqual();
            findingTypeOfTriangle();

            if (isEquilateral) {
               typeOfTriangle = "Треугольник равносторонний. ";
            } else if (isIsosceles) {
                typeOfTriangle = "Треугольник равнобедренный. ";
            }
            else {
                typeOfTriangle = "Треугольник разносторонний. ";
            }

            if (isRectangular) {
                typeOfTriangle += "Треугольник прямоугольный.";
            } else if (isAcutedAngled) {
                typeOfTriangle += "Треугольник остроугольный.";
            } else if (isObtuse) {
                typeOfTriangle += "Треугольник тупоугольный.";
            }
        }
        else {
            typeOfTriangle = "Треугольник с введёнными координатами не существует.";
        }
        return typeOfTriangle;
    }
}
