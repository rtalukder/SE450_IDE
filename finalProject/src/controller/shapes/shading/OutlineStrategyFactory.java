package controller.shapes.shading;

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
