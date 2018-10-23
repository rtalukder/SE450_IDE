package controller.shapes.shading;

import java.awt.*;

public class OutlinedRectangle implements IShadingTypeStrategy {
    @Override
    public void drawShape(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        graphics.setColor(primaryColor);
        graphics.drawRect(x, y, width, height);
    }
}
