package view.shapes.shading;

import view.interfaces.IShadingTypeStrategy;

import java.awt.*;

public class OutlinedAndFilledRectangle implements IShadingTypeStrategy {
    @Override
    public void drawShape(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        graphics.setColor(primaryColor);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(secondaryColor);
        graphics.drawRect(x, y, width, height);
    }
}
