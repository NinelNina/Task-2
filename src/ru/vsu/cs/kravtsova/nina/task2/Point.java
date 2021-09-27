package ru.vsu.cs.kravtsova.nina.task2;

public class Point {

    private double x;
    private double y;

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    Point(double x1, double y1){
        x = x1;
        y = y1;
    }

    public static double calculateDistance(Point point1, Point point2){

        //double scale = Math.pow(10, 3);

        if (point1.getX() > point2.getX() || point1.getY() > point2.getY()){
            Point tmp = point1;
            point1 = point2;
            point2 = tmp;
        }

        double distance = Math.abs(Math.sqrt((point2.x - point1.x) * (point2.x - point1.x) + (point2.y - point1.y) * (point2.y - point1.y)));

        return distance;
        //return  Math.ceil(distance * scale) / scale;
    }

}
