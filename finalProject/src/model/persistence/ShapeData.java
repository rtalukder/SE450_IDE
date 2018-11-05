package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class ShapeData  {

    public ShapeColor activePrimaryColor;
    public ShapeColor activeSecondaryColor;
    public ShapeShadingType activeShapeShadingType;
    public ShapeType activeShapeType;

    public ShapeData(ShapeColor primaryShapeColor, ShapeColor secondaryShapeColor, ShapeShadingType shapeShadingType, ShapeType shapeType){
        activePrimaryColor = primaryShapeColor;
        activeSecondaryColor = secondaryShapeColor;
        activeShapeShadingType = shapeShadingType;
        activeShapeType = shapeType;
    }
}
