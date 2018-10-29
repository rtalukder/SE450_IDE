package controller.shapes;

import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;

public class Shape implements IShape {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeData shapeData;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;

    public Shape(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        this.graphics = graphics;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeData = shapeData;
        this.primaryShapeColor = shapeData.activePrimaryColor;
        this.secondaryShapeColor = shapeData.activeSecondaryColor;
        this.shapeShadingType = shapeData.activeShapeShadingType;
        this.shapeType = shapeData.activeShapeType;
    }

    @Override
    public void drawShape() {

        IShape shape = null;
        String shapeTypeString = (shapeData.activeShapeType).toString();

        switch(shapeTypeString){
            case "RECTANGLE":
                shape = ShapeFactory.createRectangle(graphics, startPoint, endPoint, shapeData);
                break;

            case "ELLIPSE":
                shape = ShapeFactory.createEllipse(graphics, startPoint, endPoint, shapeData);
                break;

            case "TRIANGLE":
                shape = ShapeFactory.createTriangle(graphics, startPoint, endPoint, shapeData);
                break;
        }

        shape.drawShape();

    }

    @Override
    public ShapeColor getPrimaryShapeColor() {
        return primaryShapeColor;
    }

    @Override
    public ShapeColor getSecondaryShapeColor() {
        return secondaryShapeColor;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shapeShadingType;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

}
