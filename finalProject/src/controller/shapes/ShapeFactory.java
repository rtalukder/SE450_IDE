package controller.shapes;

import model.ShapeType;
import model.persistence.ShapeData;
import controller.Point;

import java.awt.*;

public class ShapeFactory {

    public ShapeFactory() {}

    public static IShape createRectangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        return new Rectangle(graphics, startPoint, endPoint, shapeData);
    }

    public static IShape createTriangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        return new Triangle(graphics, startPoint, endPoint, shapeData);
    }

    public static IShape createEllipse(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        return new Ellipse(graphics, startPoint, endPoint, shapeData);
    }
}
