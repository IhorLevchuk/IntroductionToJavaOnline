package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_4 {
    private ArrayList<Point> points;
    private final int N;
    private double greatestDistance = 0;
    private Point point1, point2;
    public Task4_4(int n){
        this.N = n;
    }

    @Override
    public String toString(){
        for (Point d: points){
            System.out.print(d);
        }
        return "\nGreatest distance is "+ greatestDistance + " between points " + point1 +" and "+ point2;
    }

    public void findingGreatestDistance(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                double distance = Math.sqrt(Math.pow((points.get(j).x-points.get(i).x),2)+Math.pow((points.get(j).y-points.get(i).y),2));
                if(distance > greatestDistance){
                    greatestDistance = distance;
                    point1 = points.get(i);
                    point2 = points.get(j);
                }
            }
        }
    }

    public void settingPoints(){
        ArrayList<Point> points = new ArrayList<>();
        for(int i = 0; i < N; i++){
            points.add(new Point((int) (Math.random() * 20), (int) (Math.random() * 20)));
        }
        this.points = points;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{"+ x +
                    ","+ y +
                    '}';
        }
    }
}
