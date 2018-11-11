package view.shapes;

import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;
import view.interfaces.IShape;

import java.awt.*;

public class Shape implements IShape {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;
    private ShapeData shapeData;

    public Shape(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData) {
        this.graphics = graphics;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryShapeColor = shapeData.activePrimaryColor;
        this.secondaryShapeColor = shapeData.activeSecondaryColor;
        this.shapeShadingType = shapeData.activeShapeShadingType;
        this.shapeType = shapeData.activeShapeType;
        this.shapeData = shapeData;
    }

    @Override
    public void drawShape() {

        IShape shape = null;

        switch((shapeData.activeShapeType).toString()){
            case "RECTANGLE":
                shape = IShapeFactory.createRectangle(graphics, startPoint, endPoint, shapeData);
                break;

            case "ELLIPSE":
                shape = IShapeFactory.createEllipse(graphics, startPoint, endPoint, shapeData);
                break;

            case "TRIANGLE":
                shape = IShapeFactory.createTriangle(graphics, startPoint, endPoint, shapeData);
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

    @Override
    public Graphics2D getGraphics(){
        return graphics;
    }

    @Override
    public ShapeData getShapeData(){
        return shapeData;
    }

    @Override
    public int getStartX() {
        return startPoint.getX();
    }

    @Override
    public int getStartY() {
        return startPoint.getY();
    }

    @Override
    public int getEndX() {
        return endPoint.getX();
    }

    @Override
    public int getEndY() {
        return endPoint.getY();
    }

}
