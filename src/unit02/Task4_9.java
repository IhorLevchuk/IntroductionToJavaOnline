package unit02;
import static java.lang.Math.*;

public class Task4_9 {
    private final int X,Y,Z,T;
    private double area;
    public Task4_9(int X, int Y, int Z, int T){
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.T = T;
    }

    public void findArea(){
        double halfPerimeter, diagonal, oppositeCorner;
        double angle = 90;
        halfPerimeter = (X+Y+Z+T)/2;
        diagonal = sqrt(pow(X,2)+ pow(Y,2));
        oppositeCorner = acos((-pow(diagonal,2)+pow(Z,2)+pow(T,2))/(2*Z*T));
        area = sqrt((halfPerimeter-X)*(halfPerimeter-Y)*(halfPerimeter-Z)*(halfPerimeter-T)-X*Y*Z*T*pow(cos((oppositeCorner+toRadians(angle))/2),2));
    }
    @Override
    public String toString(){
        return "Area of a quadrangle with sides:" + X + ", " + Y + ", " + Z + ", " + T +
                " is " + area;
    }

}
