package controller.commands;

import controller.interfaces.ICommand;
import view.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class CopyCommand implements ICommand {
    public static List<IShape> copyShapeList = new ArrayList<>();

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

