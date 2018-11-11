package controller.commands;


import controller.ShapeList;
import controller.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;
import view.interfaces.IShape;


public class DeleteCommand implements ICommand, IUndoable {

    public DeleteCommand(){}

    @Override
    public void run() {
        try {
            for (IShape shape : SelectShapeCommand.selectedShapes) {
                ShapeList.deleteFromShapeList(shape);
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
            for (IShape shape : SelectShapeCommand.selectedShapes) {
                ShapeList.addToShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }
    }

    @Override
    public void redo() {
        try {
            for (IShape shape : SelectShapeCommand.selectedShapes) {
                ShapeList.deleteFromShapeList(shape);
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }
    }
}
