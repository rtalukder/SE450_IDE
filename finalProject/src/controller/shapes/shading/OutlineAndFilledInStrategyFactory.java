package controller.shapes.shading;

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
