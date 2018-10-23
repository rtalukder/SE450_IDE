package controller.shapes.shading;

import java.awt.*;

public interface IShadingTypeStrategyTriangle {
    void drawShape(Graphics2D graphics, int [] xArray, int [] yArray, int width, int height, Color primaryColor, Color secondaryColor, int points);
}
