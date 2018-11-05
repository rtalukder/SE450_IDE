package view.shapes.shading;

import view.interfaces.IShadingTypeStrategy;

import java.awt.*;

public class FilledInEllipse implements IShadingTypeStrategy {

    @Override
    public void drawShape(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        graphics.setColor(primaryColor);
        graphics.fillOval(x, y, width, height);
    }
}
