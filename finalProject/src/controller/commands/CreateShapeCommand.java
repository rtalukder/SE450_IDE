package controller.commands;

import controller.ShapeList;
import controller.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;
import view.interfaces.IShape;
import view.shapes.Shape;
import controller.Point;
import model.persistence.ShapeData;

import java.awt.*;

public class CreateShapeCommand implements ICommand, IUndoable {
    private IShape shape;

    public CreateShapeCommand(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
            shape = new Shape(graphics, startPoint, endPoint, shapeData);
        }

    @Override
    public void run() {
        ShapeList.addToShapeList(shape);

        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        try{
            ShapeList.deleteFromShapeList(shape);
        }
        catch (NullPointerException nullPointer){
        System.out.println("Empty selectedShapes list");
        }
    }

    @Override
    public void redo() {
        ShapeList.addToShapeList(shape);
    }
}
