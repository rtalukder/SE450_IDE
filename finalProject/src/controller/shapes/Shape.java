package controller.shapes;

import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public class Shape implements IShape {
    private int x;
    private int y;
    private int height;
    private int width;

    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;

    @Override
    public String getShapeType() {
        return shapeType.toString();
    }

    @Override
    public void drawShape(Graphics graphics) {

    }


}
