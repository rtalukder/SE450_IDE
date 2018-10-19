package controller.shapes;

import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;
import java.lang.reflect.Field;

public class Rectangle implements IShape {
    private int x;
    private int y;
    private int height;
    private int width;

    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;

    public Rectangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
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
        x = Math.min(startPoint.getX(), endPoint.getX());
        y = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());

        String shapeShadingTypeString = shapeShadingType.toString();

        IShadingTypeStrategy strategy = null;

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

        /*
        TODO - refactor code to use strategy pattern
         */

        switch(shapeShadingTypeString){
            case "FILLED_IN":
                graphics.setColor(primaryColor);
                graphics.fillRect(x, y, width, height);
                break;

            case "OUTLINE":
                graphics.setColor(primaryColor);
                graphics.drawRect(x, y, width, height);
                break;

            case "OUTLINE_AND_FILLED_IN":
                graphics.setColor(primaryColor);
                graphics.fillRect(x, y, width, height);
                graphics.setColor(secondaryColor);
                graphics.drawRect(x, y, width, height);
                break;
        }
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
