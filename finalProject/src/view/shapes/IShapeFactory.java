package view.shapes;

import model.persistence.ShapeData;
import controller.Point;
import view.interfaces.IShape;

import java.awt.*;

public class IShapeFactory {

    public IShapeFactory() {}

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
