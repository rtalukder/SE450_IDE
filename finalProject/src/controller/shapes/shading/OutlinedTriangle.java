package controller.shapes.shading;

import java.awt.*;

public class OutlinedTriangle implements IShadingTypeStrategyTriangle {
    @Override
    public void drawShape(Graphics2D graphics, int [] xArray, int [] yArray, Color primaryColor, Color secondaryColor, int points) {
        graphics.setColor(primaryColor);
        graphics.drawPolygon(xArray, yArray, points);
    }
}
