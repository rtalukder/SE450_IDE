package controller.shapes.shading;

import java.awt.*;

public class OutlinedAndFilledTriangle implements IShadingTypeStrategyTriangle {
    @Override
    public void drawShape(Graphics2D graphics, int [] xArray, int [] yArray, int width, int height, Color primaryColor, Color secondaryColor, int points) {
        graphics.setColor(primaryColor);
        graphics.fillPolygon(xArray, yArray, points);
        graphics.setColor(secondaryColor);
        graphics.drawPolygon(xArray, yArray, points);
    }
}