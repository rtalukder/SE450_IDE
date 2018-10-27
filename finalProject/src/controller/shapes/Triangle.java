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
        int x1 = 0, x3= 0, y1= 0, y3= 0;
        int x2 = Math.min(startPoint.getX(), endPoint.getX());
        int y2 = 0;
        if(x2 == startPoint.getX()){
            y2 = startPoint.getY();
            x1 = endPoint.getX();
            y1 = startPoint.getY();
            x3 = Math.max(startPoint.getX(), endPoint.getX());
            y3 = endPoint.getY();
        }
        else if(x2 == endPoint.getX()){
            x1 = startPoint.getX();
            y1 = endPoint.getY();
            y2 = startPoint.getY();
            x3 = endPoint.getX();
            y3 = endPoint.getY();
        }

        int [] xArray = {x1,x2,x3};
        int [] yArray = {y1,y2,y3};

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
