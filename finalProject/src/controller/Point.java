package controller;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return ("x: " + x + ", y: " + y );
    }

    // euclidian distance calculated
    public double distanceTo(Point otherPoint) {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;

        return Math.sqrt(dx*dx + dy*dy);
    }

public void normalizedCoordinates(Point startPoint, Point endPoint){

        if (startPoint.x > endPoint.x) {
            int temp;
            temp = startPoint.x;
            startPoint.x = endPoint.x;
            endPoint.x = temp;
        }

        if (startPoint.y > endPoint.y){
            int temp;
            temp = startPoint.y;
            startPoint.y =  endPoint.y;
            endPoint.y = temp;

        }

/*        this.length = xRelease - xClick;
        this.width = yRelease - yClick;

        return this;*/
    }


}
