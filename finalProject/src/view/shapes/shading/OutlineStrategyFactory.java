package view.shapes.shading;

import view.interfaces.IShadingTypeStrategy;
import view.interfaces.IShadingTypeStrategyTriangle;

public class OutlineStrategyFactory {
    public static IShadingTypeStrategy OutlinedRectangleStrategy() {
        return new OutlinedRectangle();
    }

    public static IShadingTypeStrategyTriangle OutlinedTriangleStrategy() {
        return new OutlinedTriangle();
    }

    public static IShadingTypeStrategy OutlinedEllipseStrategy() {
        return new OutlinedEllipse();
    }
}
