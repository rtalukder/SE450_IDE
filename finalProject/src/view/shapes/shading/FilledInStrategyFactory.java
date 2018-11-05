package view.shapes.shading;

import view.interfaces.IShadingTypeStrategy;
import view.interfaces.IShadingTypeStrategyTriangle;

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
