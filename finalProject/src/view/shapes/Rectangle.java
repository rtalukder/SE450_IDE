package view.shapes;

import controller.Point;
import view.interfaces.IShape;
import view.interfaces.IShadingType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ShapeData;
import view.shapes.shading.RectangleShading;

import java.awt.*;

public class Rectangle implements IShape {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;
    private ShapeData shapeData;

    public Rectangle(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
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

        TranslateEnumColor colorTranslate = new TranslateEnumColor();
        Color primaryColor = colorTranslate.getColor(primaryShapeColor);
        Color secondaryColor = colorTranslate.getColor(secondaryShapeColor);

        IShadingType shapeToShade = new RectangleShading(graphics, x, y, width, height, primaryColor, secondaryColor);

        switch(shapeShadingType.toString()){
            case "FILLED_IN":
                shapeToShade.filledInShading();
                break;

            case "OUTLINE":
                shapeToShade.outlinedShading();
                break;

            case "OUTLINE_AND_FILLED_IN":
                shapeToShade.outlinedAndFilledShading();
                break;
        }
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
