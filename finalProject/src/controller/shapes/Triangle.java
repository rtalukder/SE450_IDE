package controller.shapes;

import controller.Point;
import controller.shapes.shading.*;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;
import java.lang.reflect.Field;

public class Triangle implements IShape {
    private int x;
    private int y;
    private int height;
    private int width;
    private final int MAX_NUMBER_OF_POINTS = 3;

    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;

    public Triangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        this.graphics = graphics;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryShapeColor = shapeData.activePrimaryColor;
        this.secondaryShapeColor = shapeData.activeSecondaryColor;
        this.shapeShadingType = shapeData.activeShapeShadingType;
        this.shapeType = shapeData.activeShapeType;
    }

    @Override
    public void drawShape() {
        int qx = 0, rx= 0, qy= 0, ry= 0;
        int px = Math.min(startPoint.getX(), endPoint.getX());
        int py = 0;
        if(px == startPoint.getX()){
            py = startPoint.getY();
            qx = endPoint.getX();
            qy = startPoint.getY();
            rx = Math.max(startPoint.getX(), endPoint.getX());
            ry = endPoint.getY();
        }
        else if(px == endPoint.getX()){
            qx = startPoint.getX();
            qy = endPoint.getY();
            py = startPoint.getY();
            rx = endPoint.getX();
            ry = endPoint.getY();
        }

        int [] xArray = {qx,px,rx};
        int [] yArray = {qy,py,ry};

        String shapeShadingTypeString = shapeShadingType.toString();
        IShadingTypeStrategyTriangle strategy = null;

        Color primaryColor;
        Color secondaryColor;

        try {
            Field primaryColorField = Color.class.getField(primaryShapeColor.toString());
            primaryColor = (Color)primaryColorField.get(null);

            Field secondaryColorField = Color.class.getField(secondaryShapeColor.toString());
            secondaryColor = (Color)secondaryColorField.get(null);
        } catch (Exception e) {
            // not defined
            primaryColor = null;
            secondaryColor = null;
        }

        switch(shapeShadingTypeString){
            case "FILLED_IN":
                strategy = new FilledInTriangle();
                break;

            case "OUTLINE":
                strategy = new OutlinedTriangle();
                break;

            case "OUTLINE_AND_FILLED_IN":
                strategy = new OutlinedAndFilledTriangle();
                break;
        }

        strategy.drawShape(graphics, xArray, yArray, width, height, primaryColor, secondaryColor, MAX_NUMBER_OF_POINTS);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
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
