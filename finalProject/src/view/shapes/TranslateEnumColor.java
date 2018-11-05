package view.shapes;

import model.ShapeColor;

import java.util.EnumMap;
import java.awt.*;

public class TranslateEnumColor {
    private EnumMap<ShapeColor, Color> enumTranslation = new EnumMap<>(ShapeColor.class);

    public TranslateEnumColor(){
        enumTranslation.put(ShapeColor.BLACK,       Color.BLACK);
        enumTranslation.put(ShapeColor.BLUE,        Color.BLUE);
        enumTranslation.put(ShapeColor.CYAN,        Color.CYAN);
        enumTranslation.put(ShapeColor.GRAY,        Color.GRAY);
        enumTranslation.put(ShapeColor.LIGHT_GRAY,  Color.LIGHT_GRAY);
        enumTranslation.put(ShapeColor.DARK_GRAY,   Color.DARK_GRAY);
        enumTranslation.put(ShapeColor.GREEN,       Color.GREEN);
        enumTranslation.put(ShapeColor.MAGENTA,     Color.MAGENTA);
        enumTranslation.put(ShapeColor.ORANGE,      Color.ORANGE);
        enumTranslation.put(ShapeColor.PINK,        Color.PINK);
        enumTranslation.put(ShapeColor.RED,         Color.RED);
        enumTranslation.put(ShapeColor.WHITE,       Color.WHITE);
        enumTranslation.put(ShapeColor.YELLOW,      Color.YELLOW);
    }

    public Color getColor(ShapeColor color){
        return enumTranslation.get(color);
    }

}
