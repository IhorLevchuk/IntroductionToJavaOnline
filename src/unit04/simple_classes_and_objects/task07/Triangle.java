package unit04.simple_classes_and_objects.task07;

import static java.lang.Math.*;

public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    private Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public static Triangle createTriangle(Point point1, Point point2, Point point3){
        return new Triangle(point1,point2,point3);
    }

    public double calculateArea(){
        return abs((((point1.getX()-point3.getX())*(point2.getY()-point3.getY()))
                -((point2.getX()-point3.getX())*(point1.getY()-point3.getY())))/2);
    }
    public double calculatePerimeter(){
        return calculateSide(point1,point2)+calculateSide(point2,point3)+calculateSide(point3,point1);
    }

    private double calculateSide(Point point1, Point point2){
        return pow(pow((point1.getX()-point2.getX()),2)+ pow((point1.getY()-point2.getY()),2),0.5);
    }

    public Point searchPointMidpoints(){
        double x = (point1.getX()+point2.getX()+point3.getX())/3;
        double y = (point1.getY()+point2.getY()+point3.getY())/3;
        return new Point(x,y);
    }

}
