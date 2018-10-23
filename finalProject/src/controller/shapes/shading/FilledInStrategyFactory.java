package controller.shapes.shading;

public class FilledInStrategyFactory {
    public static IShadingTypeStrategy FilledInRectangleStrategy() {
        return new FilledInRectangle();
    }

    public static IShadingTypeStrategyTriangle FilledInTriangleStrategy(){
        return new FilledInTriangle();
    }

    public static IShadingTypeStrategy FilledInEllipseStrategy(){
        return new FilledInEllipse();
    }

}
