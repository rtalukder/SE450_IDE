package controller;

import controller.shapes.IShape;
import java.util.List;
import java.util.ArrayList;

public class ShapeList {
    private static List<IShape> shapeList = new ArrayList<IShape>();

    public static void addToShapeList(IShape shape){
        shapeList.add(shape);
    }

    // TODO
    /* implement observer pattern here

       should send an update to ShapeDraw when a new shape is added
       update will draw the shape
     */
}
