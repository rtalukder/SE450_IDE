package view.shapes.shading;

import view.interfaces.IShadingTypeStrategy;
import view.interfaces.IShadingTypeStrategyTriangle;

public class OutlineAndFilledInStrategyFactory {
    public static IShadingTypeStrategy OutlinedAndFilledRectangleStrategy() {
        return new OutlinedAndFilledRectangle();
    }

    public static IShadingTypeStrategyTriangle OutlinedAndFilledTriangleStrategy() {
        return new OutlinedAndFilledTriangle();
    }

    public static IShadingTypeStrategy OutlinedAndFilledEllipseStrategy() {
        return new OutlinedAndFilledEllipse();
    }
}
