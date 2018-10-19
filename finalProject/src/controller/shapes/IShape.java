package controller.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IShape {
    int getX();
    int getY();
    ShapeColor getPrimaryShapeColor();
    ShapeColor getSecondaryShapeColor();
    ShapeShadingType getShadingType();
    ShapeType getShapeType();
    void drawShape();
}
