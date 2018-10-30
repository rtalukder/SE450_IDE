package controller.commands;

import controller.Point;
import controller.ShapeList;
import controller.shapes.IShape;
import controller.shapes.Shape;

import java.util.List;
import java.util.ArrayList;

public class MoveShapeCommand implements ICommand {
    private Point startPoint;
    private Point endPoint;

    public MoveShapeCommand(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run() {
        List<IShape> movedShapes = new ArrayList<>();
        int deltaX = Math.abs(endPoint.getX() - startPoint.getX());
        int deltaY = Math.abs(endPoint.getY() - startPoint.getY());

        for (IShape shape : SelectShapeCommand.selectedShapes){
            Point newStartPoint = new Point(shape.getStartX() + deltaX, shape.getStartY() + deltaY);
            Point newEndPoint = new Point(shape.getEndX() + deltaX, shape.getEndY() + deltaY);

            movedShapes.add(new Shape(shape.getGraphics(), newStartPoint, newEndPoint, shape.getShapeData()));
            ShapeList.deleteFromShapeList(shape);
        }

        for (IShape shape : movedShapes){
            ShapeList.shapeList.add(shape);
        }
    }
}
