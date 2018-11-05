package view.interfaces;

import java.awt.*;

public interface IShadingTypeStrategy {
    void drawShape(Graphics2D graphics, int x, int y, int width, int height, Color primaryColor, Color secondaryColor);
}
