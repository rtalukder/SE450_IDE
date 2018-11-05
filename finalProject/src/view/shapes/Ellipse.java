package view.shapes;

import controller.Point;
import view.interfaces.IShape;
import view.shapes.shading.FilledInEllipse;
import view.interfaces.IShadingTypeStrategy;
import view.shapes.shading.OutlinedAndFilledEllipse;
import view.shapes.shading.OutlinedEllipse;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;

import java.awt.*;

public class Ellipse implements IShape {
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

    public Ellipse(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
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
        int x = Math.min(startPoint.getX(), endPoint.getX());
        int y = Math.min(startPoint.getY(), endPoint.getY());
        int width = Math.abs(startPoint.getX() - endPoint.getX());
        int height = Math.abs(startPoint.getY() - endPoint.getY());

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
