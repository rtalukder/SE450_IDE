package view.shapes.shading;

import view.interfaces.IShadingTypeStrategyTriangle;

import java.awt.*;

public class OutlinedAndFilledTriangle implements IShadingTypeStrategyTriangle {
    @Override
    public void drawShape(Graphics2D graphics, int [] xArray, int [] yArray, Color primaryColor, Color secondaryColor, int points) {
        graphics.setColor(primaryColor);
        graphics.fillPolygon(xArray, yArray, points);
        graphics.setColor(secondaryColor);
        graphics.drawPolygon(xArray, yArray, points);
    }
}
