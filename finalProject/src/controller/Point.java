package controller;

import controller.commands.*;

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

    public double distanceTo(Point otherPoint) {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;
        
        return Math.sqrt(dx*dx + dy*dy);
    }

/*    public Point normalizedCoordinates(){

        if (xClick > xRelease) {
            int temp;
            temp = xClick;
            xClick = xRelease;
            xRelease = temp;
        }

        if (yClick > yRelease){
            int temp;
            temp = yClick;
            yClick = yRelease;
            yRelease = temp;

        }

        this.length = xRelease - xClick;
        this.width = yRelease - yClick;

        return this;
    }*/


}
