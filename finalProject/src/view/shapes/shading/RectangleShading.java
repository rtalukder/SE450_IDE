package view.shapes.shading;

import view.interfaces.IShadingType;

import java.awt.*;

public class RectangleShading implements IShadingType {
    private Graphics2D graphics;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color primaryColor;
    private Color secondaryColor;

    public RectangleShading(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor){
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
        graphics.fillRect(x, y, width, height);
    }

    @Override
    public void outlinedShading() {
        graphics.setColor(primaryColor);
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public void outlinedAndFilledShading() {
        graphics.setColor(primaryColor);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(secondaryColor);
        graphics.drawRect(x, y, width, height);
    }
}
