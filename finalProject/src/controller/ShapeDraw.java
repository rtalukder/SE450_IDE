package controller;

import controller.shapes.IShape;

public class ShapeDraw implements IShapeDrawObserver {

    @Override
    public void update() {
        for (IShape shape : ShapeList.shapeList){
            shape.drawShape();
        }
    }
}
