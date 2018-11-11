package controller.commands;

import controller.ShapeList;
import controller.interfaces.ICommand;
import view.interfaces.IShape;
import controller.Point;

import java.util.ArrayList;
import java.util.List;

public class SelectShapeCommand implements ICommand {
    public static List<IShape> selectedShapes;
    private Point selectedStartPoint;
    private Point selectedEndPoint;

    public SelectShapeCommand(Point selectedStartPoint, Point selectedEndPoint){
        selectedShapes = new ArrayList<>();
        this.selectedStartPoint = selectedStartPoint;
        this.selectedEndPoint = selectedEndPoint;
    }

    @Override
    public void run() {
        // rectangle for selected coordinates
        int xSelect = Math.min(selectedStartPoint.getX(), selectedEndPoint.getX());
        int ySelect = Math.min(selectedStartPoint.getY(), selectedEndPoint.getY());
        int widthSelect = Math.abs(selectedStartPoint.getX() - selectedEndPoint.getX());
        int heightSelect = Math.abs(selectedStartPoint.getY() - selectedEndPoint.getY());

        for (IShape shape : ShapeList.shapeList){
            // rectangle around iterated shape
            int xShape = Math.min(shape.getStartX(), shape.getEndX());
            int yShape = Math.min(shape.getStartY(), shape.getEndY());
            int widthShape = Math.abs(shape.getStartX() - shape.getEndX());
            int heightShape = Math.abs(shape.getStartY() - shape.getEndY());

            if (    xSelect < xShape + widthShape &&
                    xSelect + widthSelect > xShape &&
                    ySelect < yShape + heightShape &&
                    ySelect + heightSelect > yShape){
                selectedShapes.add(shape);
            }
        }
    }
}
