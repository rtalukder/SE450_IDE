package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class ShapeData  {

    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private ShapeType activeShapeType;

    public ShapeData(ShapeColor primaryShapeColor, ShapeColor secondaryShapeColor, ShapeShadingType shapeShadingType, ShapeType shapeType){
        activePrimaryColor = primaryShapeColor;
        activeSecondaryColor = secondaryShapeColor;
        activeShapeShadingType = shapeShadingType;
        activeShapeType = shapeType;
    }

    public ShapeData getShapeData(){
        return this;
    }

}
