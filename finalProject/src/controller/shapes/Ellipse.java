package controller.shapes;

import controller.Point;
import controller.shapes.shading.FilledInEllipse;
import controller.shapes.shading.IShadingTypeStrategy;
import controller.shapes.shading.OutlinedAndFilledEllipse;
import controller.shapes.shading.OutlinedEllipse;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.lang.reflect.Field;
import java.awt.*;

public class Ellipse implements IShape {
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

    public Ellipse(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
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

        TranslateEnumColor colorTranslate = new TranslateEnumColor();
        Color primaryColor = colorTranslate.getColor(primaryShapeColor);
        Color secondaryColor = colorTranslate.getColor(secondaryShapeColor);

        switch(shapeShadingTypeString){
            case "FILLED_IN":
                strategy = new FilledInEllipse();
                break;

            case "OUTLINE":
                strategy = new OutlinedEllipse();
                break;

            case "OUTLINE_AND_FILLED_IN":
                strategy = new OutlinedAndFilledEllipse();
                break;
        }

        strategy.drawShape(graphics, x, y, width, height, primaryColor, secondaryColor);
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
