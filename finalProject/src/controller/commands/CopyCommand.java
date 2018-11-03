package controller.commands;

import controller.shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class CopyCommand implements ICommand {
    public static List<IShape> copyShapeList = new ArrayList<>();

    public CopyCommand() {}

    @Override
    public void run() {
        try {
            copyShapeList.addAll(SelectShapeCommand.selectedShapes);
        }
        catch (NullPointerException nullPointer){
            System.out.println("Empty selectedShapes list");
        }
    }
}

