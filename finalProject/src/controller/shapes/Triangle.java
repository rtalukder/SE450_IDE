package controller.shapes;

import controller.shapes.shading.*;
import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;
import java.lang.reflect.Field;

public class Triangle implements IShape {
    private final int MAX_NUMBER_OF_POINTS = 3;
    private final Color deleteShapeFill = Color.WHITE;
    private final Color deleteShapeOutline = Color.WHITE;

    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;
    private ShapeData shapeData;

    public Triangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
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

        TranslateEnumColor colorTranslate = new TranslateEnumColor();
        Color primaryColor = colorTranslate.getColor(primaryShapeColor);
        Color secondaryColor = colorTranslate.getColor(secondaryShapeColor);

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

        strategy.drawShape(graphics, xArray, yArray, primaryColor, secondaryColor, MAX_NUMBER_OF_POINTS);
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
    public ShapeData getShapeData(){
        return shapeData;
    }

    @Override
    public Graphics2D getGraphics(){
        return graphics;
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
