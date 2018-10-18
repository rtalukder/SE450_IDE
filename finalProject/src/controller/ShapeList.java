package controller;

import controller.shapes.IShape;
import java.util.List;
import java.util.ArrayList;

public class ShapeList {
    private static List<IShape> shapeList = new ArrayList<>();

    public static void addToShapeList(IShape shape){
        shapeList.add(shape);
    }
}
