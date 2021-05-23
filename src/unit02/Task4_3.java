package unit02;
public class Task4_3 {
    private double sideFigure;

    public Task4_3(int sideFigure){
        this.sideFigure = sideFigure;
    }
    public double calculatingAreaTriangle(){
        return Math.pow(sideFigure,2)*Math.pow(3,0.5)/4;
    }
    public double calculatingAreaHexagon(){
        return calculatingAreaTriangle()*6;
    }
}
