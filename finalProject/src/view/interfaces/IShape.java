package view.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;

public interface IShape {
    ShapeColor getPrimaryShapeColor();
    ShapeColor getSecondaryShapeColor();
    ShapeShadingType getShadingType();
    ShapeType getShapeType();
    ShapeData getShapeData();
    Graphics2D getGraphics();
    void drawShape();
    int getStartX();
    int getStartY();
    int getEndX();
    int getEndY();
}
