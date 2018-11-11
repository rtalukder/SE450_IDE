package controller.commands;

import controller.Point;
import controller.ShapeList;
import controller.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;
import view.interfaces.IShape;
import view.shapes.Shape;

import java.util.List;
import java.util.ArrayList;

public class MoveShapeCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;

    private List<IShape> movedShapes;

    public MoveShapeCommand(Point startPoint, Point endPoint){
        movedShapes = new ArrayList<>();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run(){
        try {
            int deltaX = Math.abs(endPoint.getX() - startPoint.getX());
            int deltaY = Math.abs(endPoint.getY() - startPoint.getY());

            for (IShape shape : SelectShapeCommand.selectedShapes) {
                Point newStartPoint = new Point(shape.getStartX() + deltaX, shape.getStartY() + deltaY);
                Point newEndPoint = new Point(shape.getEndX() + deltaX, shape.getEndY() + deltaY);

                movedShapes.add(new Shape(shape.getGraphics(), newStartPoint, newEndPoint, shape.getShapeData()));

                ShapeList.deleteFromShapeList(shape);
            }

            for (IShape shape : movedShapes){
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }

        CommandHistory.add(this);

    }

    @Override
    public void undo() {
        try {
            for (IShape shape : movedShapes) {
                ShapeList.deleteFromShapeList(shape);
            }

            for (IShape shape : SelectShapeCommand.selectedShapes){
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty movedShapes list");
        }
    }

    @Override
    public void redo() {
        try {
            for (IShape shape : SelectShapeCommand.selectedShapes) {
                ShapeList.deleteFromShapeList(shape);
            }

            for (IShape shape : movedShapes){
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty movedShapes list");
        }
    }
}
