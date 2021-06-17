package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task07.service;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task07.bean.Point;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task07.bean.Triangle;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class TriangleAction {

    public static Triangle createTriangle(Point point1, Point point2, Point point3){
        return new Triangle(point1,point2,point3);
    }

    public double calculateArea(Triangle triangle){
        return abs((((triangle.getPoint1().getX()-triangle.getPoint3().getX())*(triangle.getPoint2().getY()-triangle.getPoint3().getY()))
                -((triangle.getPoint2().getX()-triangle.getPoint3().getX())*(triangle.getPoint1().getY()-triangle.getPoint3().getY())))/2);
    }
    public double calculatePerimeter(Triangle triangle){
        return calculateSide(triangle.getPoint1(),triangle.getPoint2())+calculateSide(triangle.getPoint2(),triangle.getPoint3())
                +calculateSide(triangle.getPoint3(),triangle.getPoint1());
    }

    private double calculateSide(Point point1, Point point2){
        return pow(pow((point1.getX()-point2.getX()),2)+ pow((point1.getY()-point2.getY()),2),0.5);
    }

    public Point searchPointMidpoints(Triangle triangle){
        double x = (triangle.getPoint1().getX()+triangle.getPoint2().getX()+triangle.getPoint3().getX())/3;
        double y = (triangle.getPoint1().getY()+triangle.getPoint2().getY()+triangle.getPoint3().getY())/3;
        return new Point(x,y);
    }
}
