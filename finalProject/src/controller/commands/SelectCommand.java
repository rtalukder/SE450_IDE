package controller.commands;

import controller.shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class SelectCommand implements ICommand {
    public static List<IShape> selectedShapes = new ArrayList<>();

    public SelectCommand(){

    }

    @Override
    public void run() {

    }
}
