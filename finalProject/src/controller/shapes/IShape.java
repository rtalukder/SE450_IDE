package controller.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
    ShapeColor getPrimaryShapeColor();
    ShapeColor getSecondaryShapeColor();
    ShapeShadingType getShadingType();
    ShapeType getShapeType();
    void drawShape();
}
