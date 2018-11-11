package controller.commands;

import controller.Point;
import controller.ShapeList;
import controller.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;
import view.interfaces.IShape;
import view.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements ICommand, IUndoable {
    private List<IShape> pastedShapes = new ArrayList<>();

    public PasteCommand(){}

    @Override
    public void run() {
        try {
            for (IShape shape : CopyCommand.copyShapeList) {
                int deltaX = 100;
                int deltaY = 100;

                Point newStartPoint = new Point(shape.getStartX() + deltaX, shape.getStartY() + deltaY);
                Point newEndPoint = new Point(shape.getEndX() + deltaX, shape.getEndY() + deltaY);

                pastedShapes.add(new Shape(shape.getGraphics(), newStartPoint, newEndPoint, shape.getShapeData()));
            }
            for (IShape shape : pastedShapes) {
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty copyShapeList list");
        }

        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        try {
            for (IShape shape : pastedShapes) {
                ShapeList.deleteFromShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }
    }

    @Override
    public void redo() {
        try {
            for (IShape shape : pastedShapes) {
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }
    }
}
