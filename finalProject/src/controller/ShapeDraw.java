package controller;

import controller.interfaces.IShapeDrawObserver;
import view.interfaces.IShape;
import view.shapes.Shape;

public class ShapeDraw implements IShapeDrawObserver {


    @Override
    public void update() {
        System.out.println((ShapeList.shapeList.size()));
        for (IShape shape : ShapeList.shapeList){
            shape.drawShape();
        }
    }
}
