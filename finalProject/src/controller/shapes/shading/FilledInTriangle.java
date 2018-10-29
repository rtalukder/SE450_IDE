package controller.shapes.shading;

import java.awt.*;

public class FilledInTriangle implements IShadingTypeStrategyTriangle {
    @Override
    public void drawShape(Graphics2D graphics, int [] xArray, int [] yArray, Color primaryColor, Color secondaryColor, int points) {
        graphics.setColor(primaryColor);
        graphics.fillPolygon(xArray, yArray, points);
    }
}
