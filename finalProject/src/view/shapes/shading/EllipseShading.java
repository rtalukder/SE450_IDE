package view.shapes.shading;

import view.interfaces.IShadingType;

import java.awt.*;

public class EllipseShading implements IShadingType {
    private Graphics2D graphics;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color primaryColor;
    private Color secondaryColor;

    public EllipseShading(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor){
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    @Override
    public void filledInShading() {
        graphics.setColor(primaryColor);
        graphics.fillOval(x, y, width, height);
    }

    @Override
    public void outlinedShading() {
        graphics.setColor(primaryColor);
        graphics.drawOval(x, y, width, height);
    }

    @Override
    public void outlinedAndFilledShading() {
        graphics.setColor(primaryColor);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(secondaryColor);
        graphics.drawOval(x, y, width, height);
    }
}
