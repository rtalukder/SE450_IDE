package controller.shapes.shading;

import java.awt.*;

public class OutlinedAndFilledEllipse implements IShadingTypeStrategy {

    @Override
    public void drawShape(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        graphics.setColor(primaryColor);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(secondaryColor);
        graphics.drawOval(x, y, width, height);
    }
}
