package view.shapes.shading;

import view.interfaces.IShadingType;

import java.awt.*;

public class TriangleShading implements IShadingType {
    private Graphics2D graphics;
    private int[] xArray;
    private int[] yArray;
    private Color primaryColor;
    private Color secondaryColor;
    private int points;

    public TriangleShading(Graphics2D graphics, int [] xArray, int [] yArray, Color primaryColor, Color secondaryColor, int points){
        this.graphics = graphics;
        this.xArray = xArray;
        this.yArray = yArray;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.points = points;
    }

    @Override
    public void filledInShading() {
        graphics.setColor(primaryColor);
        graphics.fillPolygon(xArray, yArray, points);
    }

    @Override
    public void outlinedShading() {
        graphics.setColor(primaryColor);
        graphics.drawPolygon(xArray, yArray, points);
    }

    @Override
    public void outlinedAndFilledShading() {
        graphics.setColor(primaryColor);
        graphics.fillPolygon(xArray, yArray, points);
        graphics.setColor(secondaryColor);
        graphics.drawPolygon(xArray, yArray, points);
    }
}
