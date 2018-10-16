package controller;

import controller.commands.*;

public class Point {

    int xClick;
    int yClick;
    int xRelease;
    int yRelease;

    int length;
    int width;

    public Point(int xClick, int yClick, int xRelease, int yRelease){
        this.xClick = xClick;
        this.yClick = yClick;
        this.xRelease = xRelease;
        this.yRelease = yRelease;
    }

    public Point normalizedCoordinates(){

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
    }


}
