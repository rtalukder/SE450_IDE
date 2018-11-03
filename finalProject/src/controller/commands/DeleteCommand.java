package controller.commands;


import controller.ShapeList;
import controller.shapes.IShape;


public class DeleteCommand implements ICommand {

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
    }
}
