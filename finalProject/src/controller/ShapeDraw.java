package controller;

import controller.interfaces.IShapeDrawObserver;
import view.interfaces.IShape;
import java.awt.*;

public class ShapeDraw implements IShapeDrawObserver {
    private Graphics2D graphics;

    public ShapeDraw(Graphics2D graphics){
        this.graphics = graphics;
    }

    @Override
    public void update() {
        // clear canvas before new shapes are drawn
        // could this be written better?
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 10000, 10000);

        for (IShape shape : ShapeList.shapeList){
            shape.drawShape();
        }
    }
}
